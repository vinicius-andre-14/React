import axios from "axios";


const urlbase = "http://localhost:8080/lenda";
const urllendas = "http://localhost:8080/lenda/all";

class LendaServices{

    getLenda(){
        return axios.get(urlbase+"/all");
    }

    createLenda(lenda){
        return axios.post(urlbase+"/adduser",lenda)
    }

    getLendaById(id_Lenda){
        return axios.get(urlbase+"/locate_user/"+id_Lenda);
    }

    editLenda(lenda){
        return axios.put(urlbase+"/update_user/"+lenda.id_Lenda,lenda)
    }

    deleteLenda(id_Lenda){
        return axios.delete(urlbase+"/delete_user/"+id_Lenda)
    }

    
}

export default new LendaServices();