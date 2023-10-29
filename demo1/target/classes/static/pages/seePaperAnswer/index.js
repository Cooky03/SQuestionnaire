onload = () =>{
  let qid = $util.getPageParam('questionnaireId')
  let pid = $util.getPageParam('paperId')
  let answerSource = $util.getPageParam('answerSource')
  $('#userName').val(answerSource)
  console.log(qid,answerSource)
  fetchPaperAnswer(qid, pid)
}

let questionList = []
let radio = 0
let checkbox = 0
let text = 0
let matrix = 0
let m = []
let gauge = 0

const fetchPaperAnswer = (qid, pid) =>{
  let params1 = {
    questionnaireId: qid
  }
  let params2 = {
    paperId: pid
  }
  console.log(params2, 'paperId')
  let questionList = []
  $.ajax({
    url: 'http://172.22.8.245:8089' + '/admin/queryQuestionList',
    type: "POST",
    async:false,
    data: JSON.stringify(params1),
    dataType: "json",
    contentType: "application/json",
    success(res) {
      questionList = res.data
    }
  })
  console.log(questionList)
  let paperAnswerList = []

  $.ajax({
    url: 'http://172.22.8.245:8089' + '/admin/queryPaperAnswerList',
    type: "POST",
    async:false,
    data: JSON.stringify(params2),
    dataType: "json",
    contentType: "application/json",
    success(res){
      paperAnswerList = res.data
      console.log(paperAnswerList,'paperAnswer')
    }
  })



  questionList.forEach( (item,index) => {
    console.log(item)
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
        console.log(optionList)
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

      let level = 0

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
          let found = 0
          paperAnswerList.forEach((pa)=>{
            if (pa.questionId === item.id && pa.answer.charAt(level) === String(i) && found == 0){
              $(str).append(`
            <td><input id="question${index}" type="radio" value="${i}" name="matrix${matrix}${tt}" checked="true" disabled /></td>
        `)
              found = 1
            }
          })
            if (found == 0)
            $(str).append(`
            <td><input id="question${index}" type="radio" value="${i}" name="matrix${matrix}${tt}" disabled /></td>
        `)

        }

        level++
      })
      m[matrix] = tt
    }



    if(itemtype==='5'){
      let str = '#lb' + index
      let pp = 0
      optionList.forEach((op)=>{
        if(pp===0){
          $(str).append(`
          <div>${op.optionText}</div>
          `)
        }

        let found = 0
        paperAnswerList.forEach((pa) =>{
          if (pa.questionId === item.id && pa.answer === op.optionOrder && found === 0){

            console.log('found')
            $(str).append(`
        <div>
          <label class="radio-inline">
            <input id="question${index}" type="radio" value="${pp}" name="gauge${gauge}" checked="true" disabled/>${op.fraction}
          </label>
        </div>
        `)
            found = 1
          }
        })
        if (found === 0){
          $(str).append(`
        <div>
          <label class="radio-inline">
            <input id="question${index}" type="radio" value="${pp}" name="gauge${gauge}" disabled/>${op.fraction}
          </label>
        </div>
        `)
        }


        if(pp==optionList.length-1){
          $(str).append(`
          <div>${op.optionText}</div>
          `)
        }
        pp++
      })
    }


    optionList.forEach((op)=>{
      let found = 0
      let print = 0
      paperAnswerList.forEach((pa)=>{
      if(itemtype=='1'){
        if (pa.answer === op.optionOrder && pa.questionId === item.id && found == 0){
          $('#problem').append(`
            <div style="display: flex; align-items: center; margin-bottom: 3px;">
            <label class="radio-inline">
                <input type="radio" name="radio${radio}" checked="true" disabled>${op.optionText}
            </label>
            </div>
        `)
          found = 1
        }
        if (found == 0 && pa.questionId === item.id)
          $('#problem').append(`
            <div style="display: flex; align-items: center; margin-bottom: 3px;">
            <label class="radio-inline">
                <input type="radio" name="radio${radio}" disabled>${op.optionText}
            </label>
            </div>
        `)
      }else if(itemtype=='2'){
        for (let i=0;i<paperAnswerList.length;i++){
          if (paperAnswerList[i].answer === op.optionOrder && paperAnswerList[i].questionId === item.id && found == 0){
            $('#problem').append(`
        <div style="display: flex; align-items: center; margin-bottom: 3px;">
          <label class="checkbox-inline">
            <input type="checkbox" name="chooseTerm" checked="true" disabled>${op.optionText}
          </label>
        </div>
        `)
            found = 1
            break
          }
        }
        if (found == 0 && pa.questionId === item.id)
          $('#problem').append(`
        <div style="display: flex; align-items: center; margin-bottom: 3px;">
          <label class="checkbox-inline">
            <input type="checkbox" name="chooseTerm" disabled>${op.optionText}
          </label>
        </div>
        `)

      }else if(itemtype=='3'){
        if (pa.questionId === item.id)
        $('#problem').append(`
        <textarea class="form-control" placeholder="请输入" rows="4" style="width: 70%;" disabled>${pa.answer}</textarea>
        `)
      }else if(itemtype=='4'){

      }else if(itemtype=='5'){

      }
      })
    })
    $('#problem').append(`
       </div>
     </div>
    `)
  })
}










enload = () => {
  $('#problem').append(`
    <div class="question" id="question1" data-type="1" data-problemIndex="1">
      <div class="top">
        <span class="question-title" id="questionTitle">1.单选题</span>
        <span class="must-answer" id="mustAnswer">必答题</span>
      </div>
      <div class="bottom">
        <div style="display: flex; align-items: center; margin-bottom: 3px;">
          <label class="radio-inline">
            <input type="radio" name="chooseTerm">选项1
          </label>
        </div>
        <div style="display: flex; align-items: center; margin-bottom: 3px;">
          <label class="radio-inline">
            <input type="radio" name="chooseTerm">选项2
          </label>
        </div>
        <div style="display: flex; align-items: center; margin-bottom: 3px;">
          <label class="radio-inline">
            <input type="radio" name="chooseTerm">选项3
          </label>
        </div>
        <div style="display: flex; align-items: center; margin-bottom: 3px;">
          <label class="radio-inline">
            <input type="radio" name="chooseTerm">选项4
          </label>
        </div>
      </div>
    </div>
  `)

  $('#problem').append(`
    <div class="question" id="question1" data-type="1" data-problemIndex="1">
      <div class="top">
        <span class="question-title" id="questionTitle">2.多选题</span>
        <span class="must-answer" id="mustAnswer">必答题</span>
      </div>
      <div class="bottom">
        <div style="display: flex; align-items: center; margin-bottom: 3px;">
          <label class="checkbox-inline">
            <input type="checkbox" name="chooseTerm">选项1
          </label>
        </div>
        <div style="display: flex; align-items: center; margin-bottom: 3px;">
          <label class="checkbox-inline">
            <input type="checkbox" name="chooseTerm">选项2
          </label>
        </div>
        <div style="display: flex; align-items: center; margin-bottom: 3px;">
          <label class="checkbox-inline">
            <input type="checkbox" name="chooseTerm">选项3
          </label>
        </div>
        <div style="display: flex; align-items: center; margin-bottom: 3px;">
          <label class="checkbox-inline">
            <input type="checkbox" name="chooseTerm">选项4
          </label>
        </div>
      </div>
    </div>
  `)

  $('#problem').append(`
    <div class="question" id="question1" data-type="1" data-problemIndex="1">
      <div class="top">
        <span class="question-title" id="questionTitle">3.填空题</span>
        <span class="must-answer" id="mustAnswer">必答题</span>
      </div>
      <div class="bottom">
        <textarea class="form-control" placeholder="请输入" rows="4" style="width: 70%;"></textarea>
    </div>
  `)
  $('#problem').append(`
    <div class="question" id="question1" data-type="1" data-problemIndex="1">
      <div class="top">
        <span class="question-title" id="questionTitle">4.矩阵题</span>
        <span class="must-answer" id="mustAnswer">必答题</span>
      </div>
      <div class="bottom">
        <table class="table">
          <thead>
            <tr>
              <th></th>
              <th>选项1</th>
              <th>选项2</th>
              <th>选项3</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>标题1</td>
              <td><input type="radio" name="chooseTerm1" /></td>
              <td><input type="radio" name="chooseTerm1" /></td>
              <td><input type="radio" name="chooseTerm1" /></td>
            </tr>
            <tr>
              <td>标题2</td>
              <td><input type="radio" name="chooseTerm2" /></td>
              <td><input type="radio" name="chooseTerm2" /></td>
              <td><input type="radio" name="chooseTerm2" /></td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  `)
  $('#problem').append(`
    <div class="question" id="question1" data-type="1" data-problemIndex="1">
      <div class="top">
        <span class="question-title" id="questionTitle">5.量表题</span>
        <span class="must-answer" id="mustAnswer">必答题</span>
      </div>
      <div class="bottom" style="display: flex; align-items: center; justify-content: space-between;">
        <div>很满意</div>
        <div>
          <label class="radio-inline">
            <input type="radio" name="fraction" />5
          </label>
        </div>
        <div>
          <label class="radio-inline">
            <input type="radio" name="fraction" />4
          </label>
        </div>
        <div>
          <label class="radio-inline">
            <input type="radio" name="fraction" />3
          </label>
        </div>
        <div>
          <label class="radio-inline">
            <input type="radio" name="fraction" />2
          </label>
        </div>
        <div>
          <label class="radio-inline">
            <input type="radio" name="fraction" />1
          </label>
        </div>
        <div>很不满意</div>
      </div>
    </div>
  `)
}
