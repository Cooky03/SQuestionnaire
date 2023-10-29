import os
if __name__ == "__main__":

    path = 'D:/.Homework/IdeaProjects/demo1' #分析的项目名路径,项目要有独立的文件夹
    for project_name in os.listdir(path):

        rootdir = 'D:/.Homework/IdeaProjects'  #分析的项目名路径
        dir_arr = []
        rootdir_arr = []
        root_arr = []
        depth = 1

        src_term = 'src'

        for root, dirs, files in os.walk(rootdir):
            if root.count(os.sep) == depth and project_name in str(root):
                print(root)
                dir_arr.append(root)

        for element in dir_arr:
            for root, dirs, files in os.walk(element):
                # print(root)
                # oot_split = root.split(''\)
                for elem_dir in dirs:

                    file_last = elem_dir.split('\\')[-1]
                    # print(file_last)
                    # rint(file_last)
                    if file_last == 'src':
                        replace_str = 'sdf'
                        root_tbc = root.replace(element, '')
                        root_tbc = root_tbc.replace('\\', '/')
                        root_tbc = root_tbc[1:]
                        root_arr.append(root_tbc + '/src')

            with open(element + '/sonar-project.properties', 'w') as f:
                f.write("sonar.projectKey=" + element + '\n')
                f.write("sonar.projectName=" + element + '\n')
                f.write("sonar.projectVersion=1.0\n")
                f.write('sonar.java.binaries=')
                for i in range(len(root_arr)):
                    if i != len(root_arr) - 1:
                        f.write(root_arr[i] + ',')
                    else:
                        f.write(root_arr[i] + '\n')
                root_arr.clear()
                f.write("sonar.sourceEncoding=UTF-8\n")
                f.write("sonar.language=java\n")
            f.close()

        print(project_name)
        print(element)
        #command = 'cd ' + element + ' & D:/mfy/sonar-scanner-4.2.0.1873-windows/bin/sonar-scanner.bat' #运行sonar-scanner扫描代码，根据安装路径，改写路径
        command = 'cd D:/.Homework/IdeaProjects/'+ project_name + ' & ' + 'sonar-scanner.bat -Dsonar.projectKey=demo1 -Dsonar.sources=. -Dsonar.host.url=http://localhost:9000 -Dsonar.login=admin -Dsonar.password=123456'
        print(command)

        os.system(command)



