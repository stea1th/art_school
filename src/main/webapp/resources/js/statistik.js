var ajaxStatistik = "statistik";

$(function(){
    // $('#test-btn').on('click', function(){
        $.get(ajaxStatistik+"/test")
            .done(function(data){
                createChart(data);
            });
    // });


});

function createChart(data) {

    var labels = Array();
    var thisData = Array();
     $.each(data, function (key, value) {
        labels.push(key);
        thisData.push(value);
    });

     // console.log(labels);



    // console.log(labels);
    new Chart($('#myChart'), {
        type: 'line',
        data: {
            labels: labels,
            datasets: [{
                backgroundColor: 'rgba(255, 99, 132, 0.2)',
                data: thisData
            }]
        },
        options: {}
    })
}