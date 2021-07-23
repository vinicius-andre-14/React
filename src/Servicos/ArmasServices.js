import axios from "axios";


const urlbasearma = "http://localhost:8080/armas";
const urlarmas = "http://localhost:8080/armas/all";

class ArmasServices{

    getArma(){
        return axios.get(urlbasearma+"/all");
    }

    createArma(arma){
        return axios.post(urlbasearma+"/addweapon",arma)

    }

    getArmaById(Id_Arma){
        return axios.get(urlbasearma+"/locate_arma/"+Id_Arma);
    }

    editArma(arma){
        return axios.put(urlbasearma+"/update_arma/"+arma.Id_Arma,arma)
    }

    deleteArma(Id_Arma){
        return axios.delete(urlbasearma+"/delete_arma/"+Id_Arma)
    }

}

export default new ArmasServices();