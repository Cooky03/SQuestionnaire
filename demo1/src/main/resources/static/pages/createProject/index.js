onload = () => {
  $('#headerUsername').text($util.getItem('userInfo')[0].username)
  $('#headerDivB').text('创建项目')
}

const handleCreateProject = () => {
  let now = getTimestamp()
  let params = {
    createdBy: $util.getItem('userInfo')[0].username,
    lastUpdatedBy: $util.getItem('userInfo')[0].username,
    projectName: $('#projectName').val().trim(),
    projectContent: $('#projectDescribe').val(),
    createTime: $('#createTime').val(),
    creationDate:now
  }
  if (!params.projectName) return alert('项目名称不能为空！')
  if (!params.projectContent) return alert('项目描述不能为空！')
  $.ajax({
    url: API_BASE_URL + '/addProjectInfo',
    type: "POST",
    data: JSON.stringify(params),
    dataType: "json",
    contentType: "application/json",
    success() {
      alert('创建成功！')
      location.href = "/pages/questionnaire/index.html"
    }
  })
}

const getTimestamp =()=> {
  let time = new Date()
  return time.toLocaleDateString();
}
