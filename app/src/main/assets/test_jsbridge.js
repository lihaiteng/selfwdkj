        //发送消息给java代码,使用的是DefaultHandler
        function testClick() {
            window.WebViewJavascriptBridge.send( "AAA" , function(responseData) {
                    alert("AAA"+responseData)
                }
            );
        }

        //发送消息给java代码,调用约定的handler
        function testClick1() {
            //调用本地java方法
            window.WebViewJavascriptBridge.callHandler(
                'submitFromWeb'
                , 'BBB'
                , function(responseData) {
                    alert('BBB'+responseData);
                }
            );
        }

        //注册事件监听
        function connectWebViewJavascriptBridge(callback) {
            if (window.WebViewJavascriptBridge) {
                callback(WebViewJavascriptBridge)
            } else {
                document.addEventListener(
                    'WebViewJavascriptBridgeReady'
                    , function() {
                        callback(WebViewJavascriptBridge)
                    },
                    false
                );
            }
        }
        //注册回调函数，初始化函数
        connectWebViewJavascriptBridge(function(bridge) {
            bridge.init(function(message, responseCallback) {
                alert(message);
                message = "【js】"+message;
                responseCallback(message);
            });

            bridge.registerHandler("functionInJs", function(data, responseCallback) {
                alert(data);
                data = "【js】"+data;
                responseCallback(data);
            });
        })