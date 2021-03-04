// add row
$(document).on('click', '#addRowEducation', function () {
    var html = '';
    html += '<div id="inputFormRowEducation" class="mt-3">'
    html += '<div class="form-group">'
    html += '<input type="text" name="university" class="form-control" placeholder="Учебное заведение"/>'
    html += '<input type="text" name="faculty" class="form-control mt-2" placeholder="Факультет"/>'
    html += '<input type="text" name="specialty" class="form-control mt-2" placeholder="Специальность"/>'
    html += '</div>'
    html += '<div>'
    html += '<label class="my-1 mr-2" for="startStudy">Год начала обучения</label>'
    html += '<select class="custom-select my-1 mr-sm-2 col-lg-2" id="startStudy" name="startStudy[]">'
    html += '<option value="">Выбор</option>'
    html += '<option value="2000">2000</option>'
    html += '<option value="2001">2001</option>'
    html += '<option value="2002">2002</option>'
    html += '<option value="2003">2003</option>'
    html += '<option value="2004">2004</option>'
    html += '<option value="2005">2005</option>'
    html += '<option value="2006">2006</option>'
    html += '<option value="2007">2007</option>'
    html += '<option value="2008">2008</option>'
    html += '<option value="2009">2009</option>'
    html += '<option value="2010">2010</option>'
    html += '<option value="2011">2011</option>'
    html += '<option value="2012">2012</option>'
    html += '<option value="2013">2013</option>'
    html += '<option value="2014">2014</option>'
    html += '<option value="2015">2015</option>'
    html += '<option value="2016">2016</option>'
    html += '<option value="2017">2017</option>'
    html += '<option value="2018">2018</option>'
    html += '<option value="2019">2019</option>'
    html += '<option value="2020">2020</option>'
    html += '<option value="2021">2021</option>'
    html += '<option value="2022">2022</option>'
    html += '<option value="2023">2022</option>'
    html += '<option value="2024">2022</option>'
    html += '</select>'
    html += '<label class="my-1 mr-2" for="endStudy">Год начала обучения</label>'
    html += '<select class="custom-select my-1 mr-sm-2 col-lg-2" id="endStudy" name="endStudy[]">'
    html += '<option value="">Выбор</option>'
    html += '<option value="2000">2000</option>'
    html += '<option value="2001">2001</option>'
    html += '<option value="2002">2002</option>'
    html += '<option value="2003">2003</option>'
    html += '<option value="2004">2004</option>'
    html += '<option value="2005">2005</option>'
    html += '<option value="2006">2006</option>'
    html += '<option value="2007">2007</option>'
    html += '<option value="2008">2008</option>'
    html += '<option value="2009">2009</option>'
    html += '<option value="2010">2010</option>'
    html += '<option value="2011">2011</option>'
    html += '<option value="2012">2012</option>'
    html += '<option value="2013">2013</option>'
    html += '<option value="2014">2014</option>'
    html += '<option value="2015">2015</option>'
    html += '<option value="2016">2016</option>'
    html += '<option value="2017">2017</option>'
    html += '<option value="2018">2018</option>'
    html += '<option value="2019">2019</option>'
    html += '<option value="2020">2020</option>'
    html += '<option value="2021">2021</option>'
    html += '<option value="2022">2022</option>'
    html += '<option value="2023">2022</option>'
    html += '<option value="2024">2022</option>'
    html += '</select>'
    html += '<button id="removeRowEducation" type="button" class="btn btn-danger">Remove</button>'
    html += '</div>'
    html += '</div>'

    $('#newRowEducation').append(html);
});

// remove row
$(document).on('click', '#removeRowEducation', function () {
    $(this).closest('#inputFormRowEducation').remove();
});