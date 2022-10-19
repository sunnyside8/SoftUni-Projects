function validator(obj){

    let validMethods = ['GET','POST','DELETE','CONNECT']
    let validVersions = ['HTTP/0.9', 'HTTP/1.0', 'HTTP/1.1', 'HTTP/2.0' ]
    const urlRegex = /\w+/gm;
    const message = /[<>\&'"]/gm;

    if(!obj.method || !validMethods.includes(obj.method)){
        throw new Error('Invalid request header: Invalid Method')
    }
    if(!obj.uri || obj.uri === '' || !urlRegex.test(obj.uri)){
        throw new Error('Invalid request header: Invalid URI')
    }
    if(!obj.version || !validVersions.includes(obj.version)){
        throw new Error('Invalid request header: Invalid Version')
    }
    if(obj.message === undefined || message.test(obj.message)){
        throw new Error('Invalid request header: Invalid Message')
    }

    return obj;
}
console.log(validator({
    method: 'GET',
    uri: 'svn.public.catalog',
    version: 'HTTP/1.1',
    message: ''
  }))