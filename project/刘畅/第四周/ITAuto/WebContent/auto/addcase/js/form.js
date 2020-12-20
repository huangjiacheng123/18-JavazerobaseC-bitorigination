/*刘畅加注释
function loadXMLDoc()
{
    var xmlhttp;
    if (window.XMLHttpRequest)
    {
        //  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
        xmlhttp=new XMLHttpRequest();
    }
    else
    {
        // IE6, IE5 浏览器执行代码
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange=function()
    {
        if (xmlhttp.readyState==4 && xmlhttp.status==200)
        {
            document.getElementById("myDiv").innerHTML=xmlhttp.responseText;
        }
    }
    xmlhttp.open("GET","/try/ajax/ajax_info.txt",true);
    xmlhttp.send();
}
*/

function uploadFileToServer(){
    var uploadFile = document.getElementById("upload_file_id");
    var uploadTip = document.getElementById("upload_tip_id");
    var uploadProgress = document.getElementById("upload_progress_id");
    
    if(uploadFile.value==""){
        uploadTip.innerText="请选择一个文件";
    }else if(uploadFile.files[0].size>1024 &&uploadFile.files[0].size<(40*1024*1024)){
        try{
            if(window.FileReader){
                var fReader = new FileReader();
                var xhreq=createHttpRequest();
                xhreq.onreadystatechange=function(){
                    if(xhreq.readyState==4){
                        if(xhreq.status==200){
                            uploadTip.innerText="文件上传成功";
                            setTimeout(function(){
                                hideUploadDialog()
                            },2000);    //2秒后隐藏
                        }else{
                            uploadTip.innerText="文件上传失败了";
                        }
                    }
                }
                fReader.onload=function(e){
                    xhreq.open("POST","/upload/file",true);
                    xhreq.setRequestHeader("Content-type", "application/octet-stream"); //流类型
                    xhreq.setRequestHeader("Content-length", fwFile.files[0].size);     //文件大小
                    xhreq.setRequestHeader("uploadfile_name", encodeURI(fwFile.files[0].name)); //兼容中文
                    xhreq.send(fReader.result);
                }
                fReader.onprogress = function(e){
                    uploadProgress.value = e.loaded*100/e.total;
                }
                fReader.readAsArrayBuffer(uploadFile.files[0]);
                uploadProgress.style.visibility="visible";
                uploadProgress.value = 0;
            }else{
                uploadTip.innerText="浏览器不支持上传文件";
            }
        }catch(e){
            uploadTip.innerText="文件上传失败";
        }
    }else{
        uploadTip.innerText="文件不符合要求";
    }
}
function showUploadDialog(){
    var up_dialog=document.getElementById("upload_dialog");
    document.getElementById("upload_tip_id").innerText="请选择要上传的文件";
    document.getElementById("upload_progress_id").style.visibility="hidden";
    up_dialog.style.visibility="visible";
    
}
function hideUploadDialog(){
    var up_dialog=document.getElementById("upload_dialog");
    document.getElementById("upload_progress_id").style.visibility="hidden";
    up_dialog.style.visibility="hidden";
}
var choice1 = document.getElementById("choice1");
var choice2 = document.getElementById("choice2");
var choice3 = document.getElementById("choice3");
var choice4 = document.getElementById("choice4");
var tab_bd_list = document.getElementsByClassName("tab_bd_item");
function onclickchoice1(){
    tab_bd_list[0].style.display = "block";
    tab_bd_list[1].style.display = "none";
}
function onclickchoice2(){
    tab_bd_list[1].style.display = "block";
    tab_bd_list[0].style.display = "none";
}
function onclickchoice3(){
    tab_bd_list[2].style.display = "block";
    tab_bd_list[3].style.display = "none";
}
function onclickchoice4(){
    tab_bd_list[3].style.display = "block";
    tab_bd_list[2].style.display = "none";
}
