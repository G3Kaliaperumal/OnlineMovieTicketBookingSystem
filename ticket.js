/**
 * 
 */
function priceCalculation(){
	var no = document.getElementById('noOfSeats').value;
	var cl=document.getElementById('ticketType').value;
	var value;
	if(cl == "FirstClass"){
		value= no*150;
	}
	else if(cl=="SecondClass"){
		value = no*120;
	}
	else if(cl== "BoxOffice"){
		value = no*200;
	}
	document.getElementById('result').innerHTML = "TotalPrice is "+value+"<br /> Movie Ticket Booked Successfully.";
}