var session = new IFlyTtsSession({'url': 'ws://h5.xf-yun.com/tts.do','reconnection': true,'reconnectionDelay': 30000});
var audioPalyUrl = "http://h5.xf-yun.com/audioStream/";
var p = null; /*音频播放对象 */
function startPlay(url) {
	if(plus.audio == undefined){alert("Device not ready!");}
	p = plus.audio.createPlayer(url);
	p.play(function(){},function(e) {alert( "Audio play error: " + e.message );}); 
}
function stopPlay() {
	p.stop();
}
function play(content, vcn){
	ssb_param = {"appid": '58d236cd', "appkey":"ed4a8043876c935f", "synid":"12345", "params" : "ent=aisound,aue=lame,vcn="+vcn};
	session.start(ssb_param, content, function (err, obj){
		var audio_url = audioPalyUrl + obj.audio_url;
		if( audio_url != null && audio_url != undefined ){
				if(p!=null){
					stopPlay();
				}
				startPlay(audio_url);
		}
	});
};
var HINT_IFLYTEK = '语音朗读测试';
function play_sound(){
	if(p!=null){
		console.info(p.PLAYING_STATE);
	}
	var getsex = window.localStorage.getItem("soundsex");
	var sounsrea = document.querySelector(".tts");
	if(getsex!=null){
		if(getsex=="男"){
			play(sounsrea.innerText, 'viviyufeng');
		}
		if(getsex=="女"){
			play(sounsrea.innerText, 'aisxping')
		}
	}else{
		play(sounsrea.innerText, 'viviyufeng');
	}
};