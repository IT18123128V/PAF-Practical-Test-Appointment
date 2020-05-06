//hide alert
$(document).ready(function() {

	$("#alertSuccess").hide();
	$("#alertError").hide();
	$("#hidItemIDSave").val("");
	$("#DOC")[0].reset();
});

$(document).on("click", "#btnSave", function(event) {

	// Clear alerts---------------------
	$("#alertSuccess").text("");
	$("#alertSuccess").hide();
	$("#alertError").text("");
	$("#alertError").hide();
	// Form validation-------------------
	var status = validateItemForm();
	if (status != true) {
		$("#alertError").text(status);
		$("#alertError").show();
		return;
	}
	// If valid------------------------
	var type = ($("#hidItemIDSave").val() == "") ? "POST" : "PUT";

	$.ajax({
		url : "AppointmentAPI",
		type : type,
		data : $("#DOC").serialize(),
		dataType : "text",
		complete : function(response, status) {
			onItemSaveComplete(response.responseText, status);
		}
	});

});

function onItemSaveComplete(response, status) {
	if (status == "success") {
		var resultSet = JSON.parse(response);
		if (resultSet.status.trim() == "success") {
			$("#alertSuccess").text("Successfully saved.");
			$("#alertSuccess").show();
			$("#DoctorGrid").html(resultSet.data);
		} else if (resultSet.status.trim() == "error") {
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
	} else if (status == "error") {
		$("#alertError").text("Error while saving.");
		$("#alertError").show();
	} else {
		$("#alertError").text("Unknown error while saving..");
		$("#alertError").show();
	}
	$("#hidItemIDSave").val("");
	$("#DOC")[0].reset();
}

$(document).on("click", ".btnRemove", function(event) {
	$.ajax({
		url : "AppointmentAPI",
		type : "DELETE",
		data : "nic=" + $(this).data("docid"),
		dataType : "text",
		complete : function(response, status) {
			onItemDeleteComplete(response.responseText, status);
		}
	});
});


function onItemDeleteComplete(response, status) {
	if (status == "success") {
		var resultSet = JSON.parse(response);
		if (resultSet.status.trim() == "success") {
			$("#alertSuccess").text("Successfully deleted.");
			$("#alertSuccess").show();
			$("#AppointmentGrid").html(resultSet.data);
		} else if (resultSet.status.trim() == "error") {
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
	} else if (status == "error") {
		$("#alertError").text("Error while deleting.");
		$("#alertError").show();
	} else {
		$("#alertError").text("Unknown error while deleting..");
		$("#alertError").show();
	}
}






// UPDATE==========================================
$(document).on("click", ".btnUpdate", function(event)
{
 $("#hidItemIDSave").val($(this).closest("tr").find('#hidItemIDUpdate').val());
 $("#nic").val($(this).closest("tr").find('td:eq(1)').text());
 $("#doc_spec").val($(this).closest("tr").find('td:eq(2)').text());
 $("#doctor").val($(this).closest("tr").find('td:eq(3)').text());
 $("#date").val($(this).closest("tr").find('td:eq(4)').text());
 $("#time").val($(this).closest("tr").find('td:eq(5)').text());
 $("#hospital").val($(this).closest("tr").find('td:eq(6)').text());
});
// CLIENTMODEL=========================================================================
function validateItemForm()
{
// CODE
if ($("#nic").val().trim() == "")
 {
 return "Patient NIC.";
 }
// NAME
if ($("#doc_spec").val().trim() == "")
 {
 return "Insert  Doctor's Specialty.";
 } 
//NAME
if ($("#doctor").val().trim() == "")
 {
 return "Insert  Doctor's Name.";
 } 
//NAME
if ($("#date").val().trim() == "")
 {
 return "Insert  Date.";
 } 
//NAME
if ($("#time").val().trim() == "")
 {
 return "Insert  Time.";
 } 
//NAME
if ($("#hospital").val().trim() == "")
 {
 return "Insert Hospital.";
 } 



return true;
}
