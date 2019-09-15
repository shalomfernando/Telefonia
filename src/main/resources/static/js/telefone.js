var listEntityDDD = [];
var listContato = [];

$.ajax({
    type: "GET",
    url: "/Telefone/getDDD",
    success: function(resultado){
        // console.log(resultado);
        listEntityDDD = resultado;
        // console.log(listEntityDDD);
    }
});

$.ajax({
    type: "GET",
    url: "/Contatos/get",
    success: function(resultado){
        // console.log(resultado);
        listContato = resultado;
        // console.log(listEntityDDD);
    }
});


$('.numero-digito').click(function () {

    addAnimacaoAoBotao(this);

    var currentValue = $('.numero input').val();
    var valueToAppend = $(this).attr('name');
    $('.numero input').val(currentValue + valueToAppend);

    checkNumero();
});


var timeoutTimer = true;
var timeCounter = 0;
var timeCounterCounting = true;

$('.acao-digito').click(function () {

    addAnimacaoAoBotao(this);
    if ($(this).hasClass('voltar')) {
        var currentValue = $('.numero input').val();
        var newValue = currentValue.substring(0, currentValue.length - 1);
        $('.numero input').val(newValue);
        checkNumero();
    } else if ($(this).hasClass('call')) {
        if ($('.chamada').hasClass('in-call')) {
            setTimeout(function () {
                setToInCall();
            }, 500);
            timeCounterCounting = false;
            timeCounter = 0;
            hangUpCall();
            $('.pulsate').toggleClass('active-call');

            $('.numero input').val('');
            checkNumero();
        } else {
            $('.ca-status').text('Calling');
            setTimeout(function () {
                setToInCall();
                timeoutTimer = true;
                looper();

                setTimeout(function () {
                    timeoutTimer = false;
                    timeCounterCounting = true;
                    timeCounterLoop();

                    $('.pulsate').toggleClass('active-call');
                    $('.ca-status').animate({
                        opacity: 0,
                    }, 1000, function () {
                        $(this).text('00:00');
                        $('.ca-status').attr('data-dots', '');

                        $('.ca-status').animate({
                            opacity: 1,
                        }, 1000);
                    });
                }, 3000);
            }, 500);
        }
    } else {

    }
});

var timeCounterLoop = function () {
    if (timeCounterCounting) {
        setTimeout(function () {
            var timeStringSeconds = '';
            var minutes = Math.floor(timeCounter / 60.0);
            var seconds = timeCounter % 60;
            if (minutes < 10) {
                minutes = '0' + minutes;
            }
            if (seconds < 10) {
                seconds = '0' + seconds;
            }
            $('.ca-status').text(minutes + ':' + seconds);

            timeCounter += 1;

            timeCounterLoop();
        }, 2000);
    }
};

var setToInCall = function () {
    $('.chamada').toggleClass('in-call');
    $('.call-icon').toggleClass('in-call');
    $('.call-change').toggleClass('in-call');
    $('.ca-avatar').toggleClass('in-call');
};

var dots = 0;
var looper = function () {
    if (timeoutTimer) {

        setTimeout(function () {
            if (dots > 3) {
                dots = 0;
            }
            var dotsString = '';
            for (var i = 0; i < dots - 1; i++) {
                dotsString += '.';
            }
            $('.ca-status').attr('data-dots', dotsString);
            dots += 1;

            looper();
        }, 500);
    }
};

var hangUpCall = function () {
    timeoutTimer = false;
};

var addAnimacaoAoBotao = function (thisButton) {

    $(thisButton).removeClass('clicked');
    var _this = thisButton;
    setTimeout(function () {
        $(_this).addClass('clicked');
    }, 1);
};

var checkNumero = function () {
    var numberToCheck = $('.numero input').val();


    //listEntityDDD.forEach()

    //listContato.forEach()

    var contatoDesconhecido = {
        nome: 'Desconhecido',
        numero: document.getElementById("numero").value,
        desc: 'Contato'
    };

    console.log(listContato);

        for (var x = 0; x < listContato.length; x++){
             console.log(listContato[x]);
            if (numberToCheck.length > 0 && listContato[x].numero.substring(0, numberToCheck.length) === numberToCheck) {
                showUserInfo(listContato[x]);
                break;
            } else {
                //hideUserInfo();
                showUserInfo(contatoDesconhecido);
            }
           // break;
        }


    // var contatoVictor = {
    //     name: 'Victor',
    //     number: '123456789',
    //     desc: 'Contato'
    // };
    //
    // var contatoShalom = {
    //     name: 'Shalom',
    //     number: '0651985833',
    //     desc: 'Contato',
    //     local: 'Discagem ok : Inter'
    //
    // };
    //
    // if (numberToCheck.length > 0 && contatoVictor.number.substring(0, numberToCheck.length) === numberToCheck) {
    //
    //     showUserInfo(contatoVictor);
    // } else if (numberToCheck.length > 0 && contatoShalom.number.substring(0, numberToCheck.length) === numberToCheck) {
    //     showUserInfo(contatoShalom);
    // } else {
    //     //hideUserInfo();
    //     showUserInfo(contatoDesconhecido);
    // }
};

var showUserInfo = function (userInfo) {

    console.log(userInfo);
    //$('.avatar').attr('style', "background-image: url(" + userInfo.image + ")");
    if (!$('.contato').hasClass('showcontato')) {
        $('.contato').addClass('showcontato');
    }
    var tele;
    tele = VerificadorDD(userInfo);
    if(tele !== null){
        $('.contato-nome').text(userInfo.nome);
        $('.ca-number').text(userInfo.numero+'\n '+ tele.regiao);
    }
    else {
        $('.contato-nome').text(userInfo.nome);
        $('.ca-number').text(userInfo.numero);
    }
    $('.contato-position').text(userInfo.desc);
    var matchedNumbers = $('.numero input').val();
    var remainingNumbers = userInfo.numero.substring(matchedNumbers.length);

    $('.contato-numero').html("<span>" + matchedNumbers + "</span>" + remainingNumbers);
    // $('.ca-avatar').attr('style', 'background-image: url(' + userInfo.image + ')');
    $('.ca-name').text(userInfo.nome);


};

var hideUserInfo = function () {
    $('.contato').removeClass('showcontato');
};

// $('.acao-digito').click(function (){
//     var numero = document.querySelector('#numero');
//     numero = numero.value;
//
//     console.log(numero);
//
//     $.ajax({
//          method: "GET",
//          url: "/Telefone/Post",
//          data: { nome: "Pedro", email: "pedro@email.com"}
//      });
//
// });

function VerificadorDD(telefonia) {
    var tele = new Telefone();
    //var lisTelefonia = [];
    var ddd = telefonia.numero.length === 10 ? telefonia.numero.substr(0,2) : telefonia.numero.length === 15? telefonia.numero.substr(6,1):'';

    if (telefonia.numero.length === 10){
        for ( x in  listEntityDDD){
            if(listEntityDDD[x].ddd.substr(0,2) === ddd){
                tele.setDdd(ddd);
                tele.setRegiao(listEntityDDD[x].regiao);
                tele.setDescricao(listEntityDDD[x].descricao);
                return tele;
            }
        }
    }
    else if (telefonia.numero.length === 15){
        if (telefonia.numero.substr(0,2) ==='00'){
            if (telefonia.numero.substr(2,2) === '21' || telefonia.numero.substr(2,2) === '15')  {
                for ( x in  listEntityDDD) {
                    if (listEntityDDD[x].ddd.substr(1, 1) === ddd) {
                        tele.setDdd(ddd);
                        tele.setRegiao(listEntityDDD[x].regiao);
                        tele.setDescricao(listEntityDDD[x].descricao);
                        return tele;
                    }
                }
                    tele._regiao = 'Numero invalido';
                    return tele;
            }
        }
    }
     else {
         tele._regiao = 'Numero invalido';
        return tele ;
    }
}
