onload = () => {
  $('#headerDivB').text('项目详情')
  let projectId = $util.getPageParam('seeProject')
  console.log(projectId, 'projectId')
  fetchProjectInfo(projectId)
}

let questionnaireList = []

const fetchProjectInfo = (id) => {
  let params = {
    id
  }

  $.ajax({
    url: API_BASE_URL + '/queryProjectList',
    type: "POST",
    data: JSON.stringify(params),
    dataType: "json",
    contentType: "application/json",
    success(res) {
      let info = res.data[0]
      console.log(info, 'res')
      $('#projectName').text(info.projectName)
      $('#personInCharge').text(info.lastUpdatedBy)
      $('#createTime').text(info.creationDate)
      $('#projectDescription').text(info.projectContent)
    }
  })


  $.ajax({
    url: 'http://172.22.8.245:8089' + '/admin/queryQuestionnaireList',
    type: "POST",
    data: JSON.stringify(params),
    dataType: "json",
    contentType: "application/json",

    success(res) {
      questionnaireList = res.data
      console.log(questionnaireList)
      $('#questionnaireList').html('')
      let cnt = 1
      res.data.map(item=>{
        $('#questionnaireList').append(`
        <tr>
        <td>${cnt}</td>
        <td>${item.questionnaireTitle}</td>
        <td>${item.questionnaireDescription}</td>
        <td>
        <button onclick="onRelQuestionnaire('${item.id}')">发布</button>
        <button onclick="onDelQuestionnaire('${item.id}')">删除</button>
        <button onclick="onfakeQuestionaire()">统计</button>
        <button onclick="onSeeQuestionnaire('${item.id}')">查看</button>
        </td>
        </tr>
        `)
        cnt++
      })
    }
  })
}

const onRelQuestionnaire = (id) =>{
  let param = {
    id
  }
  console.log(id)
  console.log('http://172.22.8.245:8089/q/' + id)
  let lin = 'http://172.22.8.245:8089/q/' + id
  //navigator.clipboard.writeText(lin).then(r => {alert('发布成功链接为：'+lin+'，已经复制到剪切板！')})
}

const onfakeQuestionaire = () =>{
  window.location.href = 'http://172.22.8.245:8081/questionnaire/statistics/5'
}

const onDelQuestionnaire = (qid) => {
  let state = confirm("确认删除该问卷吗？")

  if (state) {
    let params = {
      id:qid
    }
    $.ajax({
      url: 'http://172.22.8.245:8089' + '/admin/deleteQuestionnaireById',
      type: "POST",
      data: JSON.stringify(params),
      dataType: "json",
      contentType: "application/json",
      success(res) {
        alert(res.message)
        let projectId = $util.getPageParam('seeProject')
        fetchProjectInfo(projectId)
      }
    })
  }
}

const onSeeQuestionnaire = (qid) =>{
  $util.setPageParam('questionnaireId', qid)
  location.href = "/pages/seePaper/index.html"
}