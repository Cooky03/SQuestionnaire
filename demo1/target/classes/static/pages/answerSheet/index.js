onload = () =>{
  let qid = getUrlParam('questionnaireId');
  fetchAnswerSheet(qid)
}

const getUrlParam = (name) =>{
  var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
  var r = window.location.search.substr(1).match(reg);  //匹配目标参数
  if (r!=null) return unescape(r[2]); return null;
}

let questionList = []
let radio = 0
let checkbox = 0
let text = 0
let matrix = 0
let m = []
let gauge = 0

const fetchAnswerSheet = (qid) =>{
  let params = {
    questionnaireId: qid
  }
  $.ajax({
    url: 'http://172.22.8.245:8089' + '/admin/queryQuestionList',
    type: "POST",
    async:false,
    data: JSON.stringify(params),
    dataType: "json",
    contentType: "application/json",
    success(res) {
      questionList = res.data
    }
  })

  questionList.forEach( (item,index) => {
    let params_option = {
      questionId: item.questionNum,
      questionnaireId: qid
    }

    let optionList = []
    $.ajax({
      url: 'http://172.22.8.245:8089' + '/admin/queryOptionList',
      type: "POST",
      async:false,
      data: JSON.stringify(params_option),
      dataType: "json",
      contentType: "application/json",
      success(res) {
        optionList = res.data
      }
    })

    let itemtype = item.questionType
    if(itemtype == 1)radio++
    else if(itemtype == 2)checkbox++
    else if(itemtype == 3)text++
    else if (itemtype == 4)matrix++
    else gauge++

    $('#problem').append(`
    <div class="question" id="question1" data-type="1" data-problemIndex="1">
      <div class="top">
    `)

    if(item.mustAnswer = true){
      $('#problem').append(`
      <span class="question-title" id="questionTitle">${index+1}.${item.questionTitle}</span>
      <span class="must-answer" id="mustAnswer">必答题</span>
      `)
    }else{
      $('#problem').append(`
      <span class="question-title" id="questionTitle">${index}.${item.questionTitle}</span>
      <span class="must-answer" id="mustAnswer">非必答题</span>
      `)
    }

    if(itemtype == 5){
      $('#problem').append(`
    </div>
      <div class="bottom" style="display: flex; align-items: center; justify-content: space-between;" id="lb${index}">
    `)
    }else{
      $('#problem').append(`
    </div>
      <div class="bottom">
    `)
    }


    if(itemtype=='4'){
      $('#problem').append(`
      <table class="table">
          <thead>
            <tr id="headline${index}">
              <th></th>
            </tr>
          </thead>
          <tbody id="choice${index}">
          </tbody>
        </table>
      `)

      optionList.forEach((op)=>{
        let str = '#headline'+index
        $(str).append(`
        <th>${op.optionText}</th>
        `)
      })

      let array = item.leftTitle.split(',')

      let tt = 0

      array.forEach((leftitem)=>{
        tt++
        let str = '#choice' + index
        $(str).append(`
        <tr id="${matrix}${tt}">
        <td>${leftitem}</td>
        </tr>
        `)
        for(let i=0;i<optionList.length;i++){
          let str = '#'+ matrix + tt
          $(str).append(`
            <td><input id="question${index}" type="radio" value="${i}" name="matrix${matrix}${tt}" /></td>
        `)
        }
      })
      m[matrix] = tt
    }



    if(itemtype=='5'){
      let str = '#lb' + index
      let pp = 0
      optionList.forEach((op)=>{
        if(pp==0){
          $(str).append(`
          <div>${op.optionText}</div>
          `)
        }

        $(str).append(`
        <div>
          <label class="radio-inline">
            <input id="question${index}" type="radio" value="${pp}" name="gauge${gauge}" />${op.fraction}
          </label>
        </div>
        `)

        if(pp==optionList.length-1){
          $(str).append(`
          <div>${op.optionText}</div>
          `)
        }
        pp++
      })
    }

    let idx = 0
    optionList.forEach((op)=>{
      if(itemtype=='1'){
        $('#problem').append(`
        <div style="display: flex; align-items: center; margin-bottom: 3px;">
          <label class="radio-inline">
            <input id="question${index}" type="radio" name="radio${radio}" value="${idx}">${op.optionText}
          </label>
        </div>
        `)
      }else if(itemtype=='2'){
        $('#problem').append(`
        <div style="display: flex; align-items: center; margin-bottom: 3px;">
          <label class="checkbox-inline">
            <input id="question${index}" type="checkbox" name="checkbox${checkbox}" value="${idx}">${op.optionText}
          </label>
        </div>
        `)
      }else if(itemtype=='3'){
        $('#problem').append(`
        <textarea id="question${index}" class="form-control" name="text${text}" placeholder="请输入" rows="4" style="width: 70%;"></textarea>
        `)
      }else if(itemtype=='4'){

      }else if(itemtype=='5'){

      }
      idx++
    })

    $('#problem').append(`
       </div>
     </div>
    `)
  })
}

let answers = []

const tosubmit =()=>{
  let now = getTimestamp()
  let params_paper = {
    questionnaireId:getUrlParam('questionnaireId'),
    answerSource:$('#userName').val(),
    submitDate:now
  }
  let paperid = ''
  $.ajax({
    url: 'http://172.22.8.245:8089' + '/admin/addPaperInfo',
    type: "POST",
    async:false,
    data: JSON.stringify(params_paper),
    dataType: "json",
    contentType: "application/json",
    success(res) {
      paperid = res.data
    }
  })

  for(let i=1;i<=radio;i++){
    let str = 'radio'+i
    let temp = $("input[name=" + str + "]:checked").attr("id")[8]
    let val = $("input[name=" + str + "]:checked").attr("value")
    answers.push({paperId:paperid,questionId:questionList[temp].id,answer:val})
  }

  for(let i=1;i<=checkbox;i++){
    let str = 'checkbox' + i
    $("input[name=" + str + "]:checked").each(function (item){
      let temp = $(this).attr("id")[8]
      let val = $(this).attr("value")
      answers.push({paperId:paperid,questionId:questionList[temp].id,answer:val})
    })
  }

  for(let i=1;i<=text;i++){
    let str = 'text' + i
    let temp = $("textarea[name=" + str + "]").attr("id")[8]
    let val = $("textarea[name=" + str + "]").val()
    answers.push({paperId:paperid,questionId:questionList[temp].id,answer:val})
  }

  for(let i=1;i<=matrix;i++){
    let tt = m[i];
    let val = ''
    let s='matrix'+i+'1'
    let temp = $("input[name=" + s + "]:checked").attr("id")[8]
    for(let j=1;j<=tt;j++){
      let str = 'matrix' + i + j
      let valt = $("input[name=" + str + "]:checked").attr("value")
      val += valt
    }
    answers.push({paperId:paperid,questionId:questionList[temp].id,answer:val})
  }




  for(let i=1;i<=gauge;i++){
    let str = 'gauge' + i
    let temp = $("input[name=" + str + "]:checked").attr("id")[8]
    let val = $("input[name=" + str + "]:checked").attr("value")
    answers.push({paperId:paperid,questionId:questionList[temp].id,answer:val})
  }

  console.log(answers)

  answers.forEach((item)=>{
    let params_answer={
      paperId:item.paperId,
      questionId:item.questionId,
      answer:item.answer
    }
    $.ajax({
      url: 'http://172.22.8.245:8089' + '/admin/addPaperAnswerInfo',
      type: "POST",
      async:false,
      data: JSON.stringify(params_answer),
      dataType: "json",
      contentType: "application/json",
      success(res) {
      }
    })
  })
  alert('提交成功，谢谢参与')
  //window.close()
}

const getTimestamp =()=> {
  let time = new Date()
  return time.toLocaleDateString();
}

//
//
//
//
//
//
//
//
//
// enload = () => {
//   $('#problem').append(`
//     <div class="question" id="question1" data-type="1" data-problemIndex="1">
//       <div class="top">
//         <span class="question-title" id="questionTitle">1.单选题</span>
//         <span class="must-answer" id="mustAnswer">必答题</span>
//       </div>
//       <div class="bottom">
//         <div style="display: flex; align-items: center; margin-bottom: 3px;">
//           <label class="radio-inline">
//             <input type="radio" name="chooseTerm">选项1
//           </label>
//         </div>
//         <div style="display: flex; align-items: center; margin-bottom: 3px;">
//           <label class="radio-inline">
//             <input type="radio" name="chooseTerm">选项2
//           </label>
//         </div>
//         <div style="display: flex; align-items: center; margin-bottom: 3px;">
//           <label class="radio-inline">
//             <input type="radio" name="chooseTerm">选项3
//           </label>
//         </div>
//         <div style="display: flex; align-items: center; margin-bottom: 3px;">
//           <label class="radio-inline">
//             <input type="radio" name="chooseTerm">选项4
//           </label>
//         </div>
//       </div>
//     </div>
//   `)
//
//   $('#problem').append(`
//     <div class="question" id="question1" data-type="1" data-problemIndex="1">
//       <div class="top">
//         <span class="question-title" id="questionTitle">2.多选题</span>
//         <span class="must-answer" id="mustAnswer">必答题</span>
//       </div>
//       <div class="bottom">
//         <div style="display: flex; align-items: center; margin-bottom: 3px;">
//           <label class="checkbox-inline">
//             <input type="checkbox" name="chooseTerm">选项1
//           </label>
//         </div>
//         <div style="display: flex; align-items: center; margin-bottom: 3px;">
//           <label class="checkbox-inline">
//             <input type="checkbox" name="chooseTerm">选项2
//           </label>
//         </div>
//         <div style="display: flex; align-items: center; margin-bottom: 3px;">
//           <label class="checkbox-inline">
//             <input type="checkbox" name="chooseTerm">选项3
//           </label>
//         </div>
//         <div style="display: flex; align-items: center; margin-bottom: 3px;">
//           <label class="checkbox-inline">
//             <input type="checkbox" name="chooseTerm">选项4
//           </label>
//         </div>
//       </div>
//     </div>
//   `)
//
//   $('#problem').append(`
//     <div class="question" id="question1" data-type="1" data-problemIndex="1">
//       <div class="top">
//         <span class="question-title" id="questionTitle">3.填空题</span>
//         <span class="must-answer" id="mustAnswer">必答题</span>
//       </div>
//       <div class="bottom">
//         <textarea class="form-control" placeholder="请输入" rows="4" style="width: 70%;"></textarea>
//     </div>
//   `)
//   $('#problem').append(`
//     <div class="question" id="question1" data-type="1" data-problemIndex="1">
//       <div class="top">
//         <span class="question-title" id="questionTitle">4.矩阵题</span>
//         <span class="must-answer" id="mustAnswer">必答题</span>
//       </div>
//       <div class="bottom">
//         <table class="table">
//           <thead>
//             <tr>
//               <th></th>
//               <th>选项1</th>
//               <th>选项2</th>
//               <th>选项3</th>
//             </tr>
//           </thead>
//           <tbody>
//             <tr>
//               <td>标题1</td>
//               <td><input type="radio" name="chooseTerm1" /></td>
//               <td><input type="radio" name="chooseTerm1" /></td>
//               <td><input type="radio" name="chooseTerm1" /></td>
//             </tr>
//             <tr>
//               <td>标题2</td>
//               <td><input type="radio" name="chooseTerm2" /></td>
//               <td><input type="radio" name="chooseTerm2" /></td>
//               <td><input type="radio" name="chooseTerm2" /></td>
//             </tr>
//           </tbody>
//         </table>
//       </div>
//     </div>
//   `)
//   $('#problem').append(`
//     <div class="question" id="question1" data-type="1" data-problemIndex="1">
//       <div class="top">
//         <span class="question-title" id="questionTitle">5.量表题</span>
//         <span class="must-answer" id="mustAnswer">必答题</span>
//       </div>
//       <div class="bottom" style="display: flex; align-items: center; justify-content: space-between;">
//         <div>很满意</div>
//         <div>
//           <label class="radio-inline">
//             <input type="radio" name="fraction" />5
//           </label>
//         </div>
//         <div>
//           <label class="radio-inline">
//             <input type="radio" name="fraction" />4
//           </label>
//         </div>
//         <div>
//           <label class="radio-inline">
//             <input type="radio" name="fraction" />3
//           </label>
//         </div>
//         <div>
//           <label class="radio-inline">
//             <input type="radio" name="fraction" />2
//           </label>
//         </div>
//         <div>
//           <label class="radio-inline">
//             <input type="radio" name="fraction" />1
//           </label>
//         </div>
//         <div>很不满意</div>
//       </div>
//     </div>
//   `)
// }
