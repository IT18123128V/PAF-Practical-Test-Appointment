$(document).ready(function()
{
if ($("#alertSuccess").text().trim() == "")
 {
 $("#alertSuccess").hide();
 }
 $("#alertError").hide();
});
// SAVE ============================================
$(document).on("click", "#btnSave", function(event)
{
	 	
// Clear alerts---------------------
 $("#alertSuccess").text("");
 $("#alertSuccess").hide(); 
 $("#alertError").text("");
 $("#alertError").hide();
// Form validation-------------------
var status = validateItemForm();
if (status != true)
 {
 $("#alertError").text(status);
 $("#alertError").show();
 return;
 }
// If valid------------------------
 $("#DOC").submit();
 $("#alertSuccess").text("Record Aded");
 $("#alertSuccess").show();
});

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
 return "Insert NIC.";
 }
// NAME
if ($("#doc_spec").val().trim() == "")
 {
 return "Insert  Doctor Name.";
 } 
// PRICE-------------------------------
if ($("#nic").val().trim() == "")
 {
 return "Insert Room No.";
 }


return true;
}
