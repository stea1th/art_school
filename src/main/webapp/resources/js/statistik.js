var ajaxStatistik = "statistik";
var barChart;
var myData;
var myLabel;

$(function () {
    getYearsForSelect();
    getStatisticOnYearChange();
});

function getYearsForSelect() {
    var sel = $('#statistik');
    $.get(ajaxStatistik + "/years").done(function (data) {
        $.each(data, function (k, v) {
            sel.append('<option value="' + v + '" selected>' + v + '</option>');
        });
        getStatistic(sel.val());
    });
}

function getStatisticOnYearChange() {
    var sel = $('#statistik');
    sel.on('change', function () {
        getStatistic(sel.val());
    })
}

function getStatistic(year) {
    $.get(ajaxStatistik + "/chart/" + year)
        .done(function (data) {
            console.log(data);
            if(barChart === undefined){
                createChart(data);
            } else {
                fillChartWithData(data);
            }

        });
}

function addValue(data) {
    console.log(data);
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
    // console.log(activePoints);
    if (activePoints[0]) {
        var idx = activePoints[0]['_index'];
        myLabel = activePoints[0]['_model'].label;
        console.log(myData[idx]);
        if (myData[idx].childrens === null) {
            return;
        }
        console.log(myData[idx]);
        // $.each(myData[idx], function(k, v){
        //     console.log(k+" "+v);
        // });
        addValue(myData[idx]);
    }
}

function createChart(data) {

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
    fillChartWithData(data);
}

function fillChartWithData(data) {
    removeData();
    myData = $.map(data, function (n, i) {
        return [[n.childrens]];
    });

    $.map(data, function (d) {
        // console.log(d.name+" "+d.value);
        barChart.data.labels.push(d.name);
        barChart.data.datasets[0].data.push(d.value);
    });
    barChart.update();
}