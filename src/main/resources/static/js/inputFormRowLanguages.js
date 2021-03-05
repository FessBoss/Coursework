// add row
$(document).on('click', '#addRowLanguages', function () {
    var html = '';
    html += '<div id="inputFormRowLanguages">';
    html += '<div class="input-group mb-3">';
    html += '<select name="languages" >';
    html += '<option value="Русский">Русский</option>';
    html += '<option value="English (Advanced)">English (Advanced)</option>';
    html += '<option value="English (Upper-Intermediate)">English (Upper-Intermediate)</option>';
    html += '<option value="English (Intermediate)">English (Intermediate)</option>>';
    html += '<option value="English (Pre-Intermediate)">English (Pre-Intermediate)</option>';
    html += '<option value="English (Elementary)">English (Elementary)</option>';
    html += '<option value="English (Beginner)">English (Beginner)</option>';
    html += '</select>';
    html += '<div class="input-group-append">';
    html += '<button id="removeRowLanguages" type="button" class="btn btn-danger">Удалить</button>';
    html += '</div>';
    html += '</div>';

    $('#newRowLanguages').append(html);
});

// remove row
$(document).on('click', '#removeRowLanguages', function () {
    $(this).closest('#inputFormRowLanguages').remove();
});