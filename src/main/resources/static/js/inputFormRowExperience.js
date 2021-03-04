// add row
$(document).on('click', '#addRowExperience', function () {
    var html = '';
    html += '<div id="inputFormRowExperience">';
    html += '<div class="row">';
    html += '<div class="col-4">';
    html += '<label>Устроился</label>';
    html += '<input type="date" class="form-control" id="date1" name="dateStart" placeholder="Дата" required>';
    html += '</div>';
    html += '<div class="col-4">';
    html += '<label>Уволился</label>';
    html += '<input type="date" class="form-control" id="date2" name="dateEnd" placeholder="Дата" required>';
    html += '</div>';
    html += '</div>';
    html += '<div class="form-group mt-3">';
    html += '<input type="text" name="position" class="form-control" placeholder="Должность"/>';
    html += '<input type="text" name="organization" class="form-control mt-2" placeholder="Организация"/>';
    html += '<textarea name="responsibility" class="form-control mt-2" placeholder="Должностные обязанности"></textarea>';
    html += '</div>';
    html += '<div class="mt-1 mb-2">';
    html += '<button id="removeRowExperience" type="button" class="btn btn-danger">Удалить</button>';
    html += '</div>';
    html += '</div>';

    $('#newRowExperience').append(html);
});

// remove row
$(document).on('click', '#removeRowExperience', function () {
    $(this).closest('#inputFormRowExperience').remove();
});