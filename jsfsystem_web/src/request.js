import axios from "axios";

const service =axios.create({
    baseURL:"/"
})
service.interceptors.request.use((config)=>{
    config.headers['Content-Type'] = 'application/json;charset=utf-8';
return config
})
service.interceptors.response.use((res)=>{
    return res.data
}

)
export default service
