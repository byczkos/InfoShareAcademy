$(document).ready(function () {
    console.log('Document is ready');

    var $titles = $('.card-title')
    $titles.css('color', 'green').text('Sweet cat');

    $('.card .btn').on("click", function(event) {
        event.preventDefault();
        $(this).parent().parent().remove();
        $(this).css('color', 'black');
        console.log('Click ! ');
    });

    $('#add').on("click", function () {
        var $col = $('<div class="col">\
            <div class="card" style="width: 18rem;">\
            <img class="card-img-top" src="https://ichef-1.bbci.co.uk/news/660/cpsprodpb/71E1/production/_99735192_gettyimages-459467912.jpg" alt="Card image cap">\
            <div class="card-body">\
            <h5 class="card-title">Card title</h5>\
        <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card\'s content.</p>\
        <a href="#" class="btn btn-primary">Go somewhere</a>\
        </div>\
        </div>\
        </div>');

        $('.row').append($col);
    });

});