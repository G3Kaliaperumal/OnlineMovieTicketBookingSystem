/**
 * 
 */
function post(){
	var string = document.getElementById('result').value;
	var comment = document.getElementById('comment').value;
	var raterName = document.getElementById('name').value;
	var movieName = document.getElementById('movie').value;
	var rating = document.getElementById('rating').value;
	var x = document.createElement("div");
    x.textContent = string;
	var y= "<br />Movie Rater Name: "+raterName+"<br /> Movie Name: "+movieName+"<br />Rating: "+rating+
	"<br /> Comment: "+comment;
}