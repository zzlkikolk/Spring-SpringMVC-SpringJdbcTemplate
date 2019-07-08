/**
 * Ajax.js
 */
  		var xmlhttp;
  		function check(){
  			var name=document.getElementById("name").value;
  			var url="http://localhost:8080/OnLineVoting/Register?name="+name;
  			xmlhttp=new XMLHttpRequest();
  			xmlhttp.onreadystatechange=checkResult;
  			xmlhttp.open("GET", url,true);
  			xmlhttp.send();  			
  		}
  		
  		function checkResult(){
  			if(xmlhttp.readyState==4&&xmlhttp.status==200)
  				document.getElementById("result").innerHTML=xmlhttp.responseText;
  		}