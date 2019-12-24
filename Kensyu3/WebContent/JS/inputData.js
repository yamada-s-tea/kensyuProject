/**
 */

 /** 画面表示時 */
function init(){
	document.inDataForm.okBtn.disabled = true;
}

/** okボタンの表示制御 */
function startBtnDis(){
	var name = document.inDataForm.name.value;
	var attack = document.inDataForm.attack.value;
	var way = document.inDataForm.way.value;

	if(name == "" || attack == 0 || way == 0){
		document.inDataForm.startBtn.disabled = true;
	} else {
		document.inDataForm.startBtn.disabled = false;
	}
}