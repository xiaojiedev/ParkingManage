var coreUtil = (function () {
    var coreUtil = {};
    /**
     * ajax请求封装
     * @param url 请求的接口地址
     * @param params 传递给后端的数据
     * @param ft 响应成功后的回调函数 callback
     * @param method 请求的方式 GET/POST/PUT/DELETE/..
     * @param headers 请求头
     * @param async 是否异步请求 async的默认方式是true,即异步方式；async设置为false时,为同步方式
     * @param contentType 默认为: application/json; charset=UTF-8
     */
    coreUtil.sendAjax = function (url, params, ft, method, headers, async, contentType) {
        var roleSaveLoading = top.layer.msg('数据提交中，请稍候', {icon: 16, time: false, shade: 0.8});
        layui.jquery.ajax({
            url: url,
            cache: false,
            async: async === undefined ? true : async,
            data: params,
            type: method === undefined ? "POST" : method,
            contentType: contentType === undefined ? 'application/json; charset=UTF-8' : contentType,
            dataType: "json",
            beforeSend: function (request) {
                if (headers) {
                    // headers=true需要header携带token;
                    request.setRequestHeader("Authorization", coreUtil.getLocalData("token"));
                }
            },
            success: function (res) {
                console.info("success")
                top.layer.close(roleSaveLoading);
                if (typeof ft == "function") {
                    console.info(res)
                    switch (res.code) {
                        case 0: // 成功响应
                            if (ft != null && ft !== undefined) {
                                ft(res);
                            }
                            break;
                        case 1002: //token失效
                            layer.msg(res.msg, {icon: 3})
                            setTimeout(function () {
                                window.location.href = "page/login.html"
                            }, 1000)
                            break;
                        case 1001: //token为空
                            layer.msg(res.msg, {icon: 3})
                            setTimeout(function () {
                                window.location.href = "page/login.html"
                            }, 1000)
                            break;
                        default:
                            layer.msg(res.msg, {icon: 2})
                            break;
                    }
                }
            }, error: function (XMLHttpRequest, textStatus, errorThrown) {
                console.info("error")
                top.layer.close(roleSaveLoading);
                if (XMLHttpRequest.status === 404) {
                    // 跳转错误页面
                    top.window.location.href = "/page/error/404.html";
                } else {
                    console.info(XMLHttpRequest)
                    layer.msg("服务器好像除了点问题!请稍后试试");
                }
            }
        });
    };

    /**
     * 存入本地缓存
     * @param key
     * @param value
     */
    coreUtil.setLocalData = function (key, value) {
        layui.sessionData('LocalData', {
            key: key,
            value: value
        })
    };
    /**
     * 从本地缓存拿数据
     * @param key
     */
    coreUtil.getLocalData = function (key) {
        var localData = layui.sessionData('LocalData');
        return localData[key];
    };
    /**
     * 格式化时间格式
     * @param val
     */
    coreUtil.formateTime = function (val) {
        if (val == null || val === undefined) {
            return "";
        }
        var date = new Date(val);
        var year = date.getFullYear();
        var month = date.getMonth() + 1;
        month = month > 9 ? month : ('0' + month);
        var day = date.getDate();
        day = day > 9 ? day : ('0' + day);
        var hh = date.getHours();
        hh = hh > 9 ? hh : ('0' + hh);
        var mm = date.getMinutes();
        mm = mm > 9 ? mm : ('0' + mm);
        var ss = date.getSeconds();
        ss = ss > 9 ? ss : ('0' + ss);
        return year + '-' + month + '-' + day + ' ' + hh + ':' + mm + ':' + ss;
    };
    /**
     * 去除重复的字符串
     * @param str
     * @returns {string}
     */
    coreUtil.removeRepeat = function (str) {
        var newStr = '';
        var len = str.length;
        for (var i = 0; i < len; i++) {
            if (newStr.search(str[i]) === -1) {
                newStr = newStr + str[i];
            }
        }
        return newStr;
    }
    return coreUtil;
})(coreUtil, window);
