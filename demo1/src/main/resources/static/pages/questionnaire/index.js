onload = () => {
  $('#headerUsername').text($util.getItem('userInfo')[0].username)
  fetchProjectList()
}

let projectList = []

const fetchProjectList = () => {
  console.log($util.getItem('userInfo'))
  console.log($util.getItem('userInfo')[0].username)
  let params = {
    createdBy: $util.getItem('userInfo')[0].username,
    projectName: $('#projectName').val()
  }
  console.log(params.createdBy)
  $.ajax({
    url: API_BASE_URL + '/queryProjectList',
    type: "POST",
    data: JSON.stringify(params),
    dataType: "json",
    contentType: "application/json",
    success(res) {
      projectList = res.data
      $('#content').html('')
      let cnt = 0
      res.data.map(item => {
        $('#content').append(`
          <div class="list">
            <div class="list-header">
              <div>${item.projectName}</div>
              <div>
                <button type="button" class="btn btn-link" onclick="onCreateQuestionnaire('${item.projectName}')">创建问卷</button>
                <button type="button" class="btn btn-link" onclick="onSeeProject('${item.id}')">查看</button>
                <button type="button" class="btn btn-link" onclick="onEditProject('${item.id}')">编辑</button>
                <button type="button" class="btn btn-link" onclick="onDelProject('${item.id}')">删除</button>
                <button type="button" class="btn btn-link" onclick="">统计</button>
              </div>
            </div>
            <div class="list-footer" id="questionnaireList${cnt}">
              
            </div>
          </div>
        `)

        let param_pid = {
          id:item.id
        }

        $.ajax({
          url: 'http://172.22.8.245:8089' + '/admin/queryQuestionnaireList',
          type: "POST",
          data: JSON.stringify(param_pid),
          async:false,
          dataType: "json",
          contentType: "application/json",

          success(res) {
            questionnaireList = res.data
            console.log(questionnaireList)
            let str = "#questionnaireList"+cnt
            if(res.data == '0'){
              $(str).append(`
              <div>暂无问卷或问卷已过期</div>
              `)
            }else{
              res.data.map(list=>{
                $(str).append(`
               <div>问卷名：${list.questionnaireTitle}&nbsp;&nbsp;&nbsp;&nbsp;问卷类型：${list.questionnaireType}&nbsp;&nbsp;&nbsp;&nbsp;问卷描述：${list.questionnaireDescription}</div><hr>
              `)
              })
            }
            cnt++
          }
        })
      })
    }
  })
}

const onCreatePrject = () => {
  location.href = "/pages/createProject/index.html"
}

const onCreateQuestionnaire = (name) => {
  console.log(name)
  $util.setPageParam('selectedpn',name)
  location.href = "/pages/createQuestionnaire/index.html"
}

const onSeeProject = (id) => {
  $util.setPageParam('seeProject', id)
  location.href = "/pages/seeProject/index.html"
}

const onEditProject = (id) => {
  let project = projectList.filter(item => item.id === id)[0]
  $util.setPageParam('editProject', project)
  location.href = "/pages/editProject/index.html"
}

const onDelProject = (pid) => {
  let state = confirm("确认删除该项目吗？")

  if (state) {
    let params = {
      id:pid
    }
    //alert(JSON.stringify(params))
    $.ajax({
      url: API_BASE_URL + '/deleteProjectById',
      type: "POST",
      data: JSON.stringify(params),
      dataType: "json",
      contentType: "application/json",
      success(res) {
        alert(res.message)
        fetchProjectList()
      }
    })
  }
  
}
