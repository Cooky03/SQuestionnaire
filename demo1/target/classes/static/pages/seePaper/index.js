onload = () => {
  $('#headerDivB').text('问卷回答详情')
  $('#headerUsername').text($util.getItem('userInfo')[0].username)
  let questionnaireId = $util.getPageParam('questionnaireId')
  let projectId = $util.getPageParam('seeProject')
  console.log(questionnaireId, 'questionnaireId')
  console.log(projectId, 'projectId')
  fetchQuestionnaireInfo(questionnaireId)
}

let paperList = []

const fetchQuestionnaireInfo = (qid) => {
  let params1 = {
    id:qid
  }
  let params2 = {
    questionnaireId:qid
  }
  console.log(params1)
  console.log(params2)
  $.ajax({
    url: 'http://172.22.8.245:8089' + '/admin/findQuestionnaireById',
    type: "POST",
    data: JSON.stringify(params1),
    dataType: "json",
    contentType: "application/json",
    success(res) {
      let info = res.data[0]
      console.log(info, 'res')
      $('#questionnaireTitle').text(info.questionnaireTitle)
      $('#createTime').text(info.creationTime)
      $('#questionnaireDescription').text(info.questionnaireDescription)
    }
  })


  $.ajax({
    url: 'http://172.22.8.245:8089' + '/admin/queryPaperList',
    type: "POST",
    data: JSON.stringify(params2),
    dataType: "json",
    contentType: "application/json",

    success(res) {
      console.log(res.data)
      paperList = res.data
      console.log(paperList)
      $('#paperList').html('')
      let cnt = 1
      if(res.data == '0'){
        $('#paperList').append(`
        <div>未收到任何答卷</div>
        `)
      }else{
        res.data.map(item=>{
          $('#paperList').append(`
        <tr>
        <td>${cnt}</td>
        <td>${item.answerSource}</td>
        <td>${item.submitDate}</td>
        <td>
        <button onclick="onSeePaperAnswer('${item.id}','${item.questionnaireId}','${item.answerSource}')">查看</button>
        </td>
        </tr>
        `)
          cnt++
        })
      }
    }
  })
}

const onSeePaperAnswer = (pid, qid, answer) =>{
  $util.setPageParam('paperId', pid)
  $util.setPageParam('questionnaireId', qid)
  $util.setPageParam('answerSource', answer)
  location.href = "/pages/seePaperAnswer/index.html"
}