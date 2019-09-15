    class Telefone{
            constructor (descricao, regiao, ddd ){
             this._descricao = descricao;
             this._regiao = regiao;
             this._ddd = ddd;
           //  Object.freeze(this);
        }

        get descricao (){
            return this._descricao;
        }
        get regiao(){
            return this._regiao;
        }
        get ddd(){
            return this._ddd;
        }
        setDescricao (descricao){
            this._descricao = descricao;
        }
        setDdd (ddd){
            this._ddd = ddd;
        }
        setRegiao (regiao){
            this._regiao = regiao;
        }


    }