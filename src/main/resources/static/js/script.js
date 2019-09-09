function abrirPorta() {
    var idPorta = document.querySelector('.porta.direito');
    console.log(idPorta);
    idPorta.style.animation = "porta 15s linear 0s infinite forwards";
atualizaContador(5);

}

var ss = -1;
function atualizaContador(futuro)
{
    ss = (ss==-1) ? futuro : ss;

    if (ss > 0) {
        ss--;
        setTimeout(atualizaContador,500);
    } else {
        location.href="/Telefone";
    }
}