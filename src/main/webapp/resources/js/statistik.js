var ajaxStatistik = "/api/statistik";
var sel = $('#statistik');
var barChart;
var myData;
var myLabel;

$(function () {
    getYearsForSelect();
    getStatisticOnYearChange();
});

function getYearsForSelect() {
    $.get(ajaxStatistik + "/years").done(function (data) {
        $.each(data, function (k, v) {
            sel.append('<option value="' + v + '" selected>' + v + '</option>');
        });
        getStatistic(sel.val());
    });
}

function getStatisticOnYearChange() {
    sel.on('change', function () {
        getStatistic(sel.val());
    })
}

function getStatistic(year) {
    $.get(ajaxStatistik + "/chart/" + year)
        .done(function (data) {
            if(barChart === undefined){
                createChart(data);
            } else {
                fillChartWithData(data);
            }
        });
}

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
    barChart.data.datasets[0].label = "";
    barChart.update();
}

function onClickSelectCategory(e) {
    var activePoints = barChart.getElementsAtEvent(e);
    if (activePoints[0]) {
        var idx = activePoints[0]['_index'];
        myLabel = activePoints[0]['_model'].label;
        if (myData[idx].childrens === null) {
            return;
        }
        addValue(myData[idx]);
    }
}

function createChart(data) {

    barChart = new Chart($('#myChart'), {
        type: 'bar',
        data: {
            datasets: [{
                backgroundColor: 'rgba(255, 99, 132, 0.8)',

                 label: sel.val()
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
        barChart.data.datasets[0].label = sel.val();
        barChart.data.labels.push(d.name);
        barChart.data.datasets[0].data.push(d.value);
    });
    barChart.update();
}