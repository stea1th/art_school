var ajaxStatistik = "statistik";
var barChart;
var myData;
var myLabel;

$(function () {
    $.get(ajaxStatistik + "/test")
        .done(function (data) {
            console.log(data);
            createChart(data);
            console.log(barChart.data.datasets[0]);
        });
});

function addValue(data) {
    myData = data[0];
    removeData();
    $.map(myData, function (d) {
        barChart.data.labels.push(d.name);
        barChart.data.datasets[0].data.push(d.value);
        barChart.data.datasets[0].label = myLabel;
    });
    barChart.update();
}

function removeData() {
    barChart.data.labels.splice(0, barChart.data.labels.length);
    barChart.data.datasets[0].data.splice(0, barChart.data.datasets[0].data.length);
    // barChart.data.datasets[0].label.splice(0, barChart.data.datasets[0].label.length);
    barChart.update();
}

function onClickSelectCategory(e) {
    var activePoints = barChart.getElementsAtEvent(e);
    console.log(activePoints);
    if (activePoints[0]) {
        var idx = activePoints[0]['_index'];
        myLabel = activePoints[0]['_model'].label;
        console.log(myData[idx]);
        addValue(myData[idx]);
    }
}

function createChart(data) {
    myData = $.map(data, function (n, i) {
        return [[n.childrens]];
    });

    barChart = new Chart($('#myChart'), {
        type: 'bar',
        data: {
            datasets: [{
                backgroundColor: 'rgba(255, 99, 132, 0.8)',

                label: 'Test Label'
            }]
        },
        options: {
            onClick: function (e) {
                onClickSelectCategory(e);
            },
            animation: {
                duration: 2000,
                easing: 'easeInOutElastic',
                animateScale: true
            },
            scales: {
                yAxes: [{
                    ticks: {
                        beginAtZero: true
                    }
                }]
            },
            title: {
                display: true,
                text: 'Статистика заработка'
            },
            legend: {
                display: true
            }
        }
    });

    $.map(data, function (d) {
        console.log(d.name);
        barChart.data.labels.push(d.name);
        barChart.data.datasets[0].data.push(d.value);
    });
    barChart.update();
}