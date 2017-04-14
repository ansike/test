<?php


	header("Content-Type: text/html;charset=utf-8");
	$appid = "wx23f0e6c4c375f363"; // 必须修改
	$appsecret = "c45fb0e6d2db22c79d23cea567c9b2ab"; // 必须修改
	$noncestr = "Wm3WZYTPz0wzccnW";
	$timestamp = "1464676595755";
	$ipturl = $_SERVER["HTTP_REFERER"];
    $url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s";

    session_start();
    
    $_SESSION["signature"]='';

    if(empty($_SESSION["signature"]) || (!empty($_SESSION["expiretime"]) && $_SESSION["expiretime"] < time())) {
	    $url = sprintf($url, $appid, $appsecret);
		$content = file_get_contents($url);

		$arr = (Array)json_decode($content); 
		
		if(empty($arr["access_token"])) {
			echo "您输入的内容有错误。无法计算签名。";
			return;
		}

		$access_token = $arr["access_token"];

		$url = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=%s&type=jsapi";
		$url = sprintf($url, $access_token);
		$content = file_get_contents($url);
		$arr = (Array)json_decode($content);
		$jsapi_ticket = $arr["ticket"];



		$string1 = "jsapi_ticket=%s&noncestr=%s&timestamp=%s&url=%s";
		$string1 = sprintf($string1, $jsapi_ticket, $noncestr, $timestamp, $ipturl);
		// echo $jsapi_ticket."<br>";
		// echo $noncestr."<br>";
		// echo $timestamp."<br>";
		// echo $string1."<br>";
		$signature = sha1($string1);
		// echo $access_token . "<br>";
		// echo $jsapi_ticket . "<br>";
		// echo $signature . "<br>";
//		$_SESSION['expiretime'] = time() + 10;
//		$_SESSION["signature"]=$signature;
    } else {
    	$signature = $_SESSION["signature"];
    }

	$rst = "wx.config({
	    debug: false,
	    appId: '%s',
	    timestamp: '%s',
	    nonceStr: '%s',
	    signature: '%s',
	    jsApiList: ['scanQRCode','chooseImage','getLocation','translateVoice','uploadImage','getNetworkType','openLocation','startRecord','stopRecord','playVoice','translateVoice']
	});//";
	$rst = sprintf($rst, $appid, $timestamp, $noncestr, $signature);
	echo "//" . $ipturl . "\n";
	echo $rst;
