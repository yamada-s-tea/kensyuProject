/**
 */

// document.forms[0].name属性.valueで値を取得できる
// document.formのname属性.elements[0].valueで値を取得できる
// visibility hidden 非表示 visible 表示
// display none 非表示 block ブロックとして表示

function registDisabled() {
	var name1 = document.registInfo.elements[0].value;
	var name2 = document.registInfo.elements[1].value;
	var age = document.forms[0].age.value;
	var sex = document.forms[0].sex.value;
	var adress2 = document.forms[0].adress2.value;
	var biko = document.forms[0].biko.value;

	var regexp = new RegExp(/\D/);

	if (name1 == "" || name2 == "" || age == "" || sex == 0 || adress2 == ""
			|| biko == "") {
		document.forms[0].registBtn.disabled = true;
	} else {
		document.forms[0].registBtn.disabled = false;
	}

	var regexp = new RegExp(/\D/);
	if (age.match(regexp) == null){ // matchメソッドの戻り値は合致無しならnull、合致したらその文字列
		// document.getElementById("ageError").style.visibility ="hidden";
		document.getElementById("ageError").style.display ="none"
	} else {
		document.forms[0].registBtn.disabled = true;
		document.getElementById("ageError").style.display ="block";
	}
}

function init() {
	document.forms[0].registBtn.disabled = true;
	document.getElementById("ageError").style.display ="none";
}