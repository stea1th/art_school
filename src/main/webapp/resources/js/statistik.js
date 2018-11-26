var ajaxStatistik = "statistik";

$(function(){
    // $('#test-btn').on('click', function(){
        $.get(ajaxStatistik+"/test")
            .done(function(data){
                console.log(data);
                createChart(data);
            });
    // });


});

function createChart(data) {

    var labels = Array();
    var thisData = Array();
     $.each(data, function (key, value) {
         // console.log(value[0].monat);
         labels.push(value[0].monat);
         thisData.push(value[0].sum);
    });

    new Chart($('#myChart'), {
        type: 'bar',
        data: {
            labels: labels,
            datasets: [{
                backgroundColor: 'rgba(255, 99, 132, 0.2)',
                data: thisData
            }]
        },
        options: {
            // onClick :
        }
    })
}