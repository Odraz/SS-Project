var shoppingCart = [];
var totalPrice = 0;

function addToCart(name, price){
	var item = {};

	item.Name = name;
	item.Price = price;
	
	totalPrice += price;
	
    shoppingCart.push(item);

    updateCart();
}

function removeFromCart(id){
	totalPrice -= shoppingCart[id].Price;
    shoppingCart.splice(id, 1);
    
    updateCart();
}

function updateCart(){	
	if(shoppingCart.length == 0){
		$('#cart').hide();
		$('#cart-msg').show();
	}else{
		$('#cart').show();
		$('#cart-msg').hide();
	}
	
	$('#cart-items').html('');
	
	var i = 0;
	shoppingCart.forEach(function(item){
		$("#cart-items").append("<li><h2>" + item.Name + " - " + item.Price + "</h2><button class=\"btn btn-lg btn-primary btn-block\"  onclick=\"removeFromCart(" + i + ")\">Remove from cart</button></li>");
		i++;
	});	
	
	$('#cart-total-price').html(totalPrice);	
}

$(function() {	
	updateCart();
});
