//总页数
const totalPage = 100
//当前页数
const page = 6
function _click(target){
    let btnText = target.innerText
    let pre = ""
    let tail = ""
    if(window.location.href.indexOf('/tab/good') != -1) {
        pre = '/tab/good/?'
    } else if (window.location.href.indexOf('/tab/share') != -1) {
        pre = '/tab/share/?'
    } else if(window.location.href.indexOf('/tab/ask') != -1) {
        pre = '/tab/ask/?'
    } else if(window.location.href.indexOf('/tab/job') != -1) {
        pre = '/tab/job/?'
    } else if(window.location.href.indexOf('/search') != -1){
        let start = window.location.href.indexOf('&')
        tail = window.location.href.substr(start)
        pre = '/search/?'
        console.log(tail)
    } else {
        pre = "/?"
    }
    if(btnText === '<<') {
        window.location.href = pre + 'page=' + 1 + tail
    }
    else if(btnText === '>>') {
        window.location.href = pre + 'page=' + totalPage + tail
    }
    else {
        window.location.href = pre + 'page=' + target.innerText + tail
    }
}

/**
 * 生成分页条， 后台需要提供totalPage和page参数
 */
$(function(){

    //规定分页栏数字按钮最多只有5个
    const totalBtns = 5
    //生成分页按钮
    var pagenationBtns = '<button class="btn btn-default btn-group-lg" onclick="_click(this)"><<</button>'
    //生成中间的数字按钮
    //总页数小于等于totalBtns， 则显示totalPage个按钮
    if(totalPage <= totalBtns) { 
        for(let i=1; i<=totalPage; i++) {
            if(i != page) {
                pagenationBtns += '<button class="btn btn-default btn-group-lg" onclick="_click(this)">' + i + '</button>'
            } else {
                pagenationBtns += '<button class="btn btn-default btn-group-lg selected" onclick="_click(this)">' + i + '</button>'
            }
        }
    }
    //总页数大于totalBtns且当前页数小于总页数减2且当前页数小于totalBtns， 则显示在5个数字按钮右两边添加 ... 按钮
    else if(totalPage > totalBtns && page < totalPage - 2 && page < totalBtns) {
        for(let i=1; i<=totalBtns; i++){
            if(i != page) {
                pagenationBtns += '<button class="btn btn-default btn-group-lg" onclick="_click(this)">' + i + '</button>'
            } else {
                pagenationBtns += '<button class="btn btn-default btn-group-lg selected" onclick="_click(this)">' + i + '</button>'
            }
        }
        pagenationBtns += '<button class="btn btn-default btn-group-lg">...</button>'
    }
    //总页数大于totalBtns且当前页数小于总页数减2且当前页数大于等于totalBtns， 则显示在5个数字按钮左右两边添加 ... 按钮
    else if(totalPage > totalBtns && page < totalPage - 2 && page >= totalBtns) { 
        pagenationBtns += '<button class="btn btn-default btn-group-lg">...</button>'
        for(let i=0; i<totalBtns; i++){
            let num = page - 2 + i
            if(num != page) {
                pagenationBtns += '<button class="btn btn-default btn-group-lg" onclick="_click(this)">' + num + '</button>'
            } else {
                pagenationBtns += '<button class="btn btn-default btn-group-lg selected" onclick="_click(this)">' + num + '</button>'
            }
        }
        pagenationBtns += '<button class="btn btn-default">...</button>'
    }
    //总页数大于totalBtns且当前页数大于等于总页数减2， 则显示在5个数字按钮左边添加 ... 按钮
    else if (totalPage > totalBtns && page >= totalPage - 2) {
        pagenationBtns += '<button class="btn btn-default btn-group-lg">...</button>'
        for(let i=totalPage - totalBtns + 1; i<=totalPage; i++) {
            if(i != page) {
                pagenationBtns += '<button class="btn btn-default btn-group-lg" onclick="_click(this)">' + i + '</button>'
            } else {
                pagenationBtns += '<button class="btn btn-default btn-group-lg selected" onclick="_click(this)">' + i + '</button>'
            }
        }
    }
    pagenationBtns += '<button class="btn btn-default btn-group-lg" onclick="_click(this)">>></button>'
    $(pagenationBtns).appendTo('#pagenationBar')
})


