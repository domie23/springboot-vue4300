const base = {
    get() {
        return {
            url : "http://localhost:8080/gaoxiaobiyeshejiguanli/",
            name: "gaoxiaobiyeshejiguanli",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/gaoxiaobiyeshejiguanli/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "高校毕业设计管理系统"
        } 
    }
}
export default base
