const base = {
    get() {
        return {
            url : "http://localhost:8080/ssmu0974/",
            name: "ssmu0974",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/ssmu0974/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "基于Web的研究生信息管理系统"
        } 
    }
}
export default base
