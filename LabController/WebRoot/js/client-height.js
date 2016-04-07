/**
 * Created by H&J on 2015/12/29.
 */
var a=document.getElementById("contain");
var b=document.getElementById("content");
var c=document.getElementById("footer");
a.style.height= b.offsetHeight+ c.offsetHeight+50+"px";
a.style.minHeight=document.documentElement.clientHeight-100+"px";