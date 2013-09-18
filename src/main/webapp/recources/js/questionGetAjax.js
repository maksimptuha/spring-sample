var questionGetAjax = (function(questionGetAjax) {
//    questionGetAjax.addAnswer = function() {
//        var $answerForm = $('div#answer-form form');
//        $answerForm.submit(function(e) {
//            e.preventDefault();
//            console.log($answerForm.serialize());
//        });
//    }

    questionGetAjax.deleteAnswer = function(url) {
        $.getJSON(url, function(answerId) {
            $('div.answer-' + answerId).remove();
        });

        var $answerCounter = $('div.answers-block-counter h4'),
            answerCounterData = $answerCounter.text().split(' '),
            newAnswerAmount = answerCounterData[0] - 1,
            answersCounterMessage = answerCounterData[1];

        $answerCounter.text(newAnswerAmount + ' ' + answersCounterMessage);
    };

    questionGetAjax.questionLike = function() {
        $.getJSON('/questions/like', {questionId : $('#questionId').val()}, function(likes) {
                $('div#question-likes span').text(likes);
        });
    };

    questionGetAjax.questionDislike = function() {
        $.getJSON('/questions/dislike', {questionId : $('#questionId').val()}, function(likes) {
            $('div#question-likes span').text(likes);
        });
    };

    questionGetAjax.answerLike = function(answerId) {
        $.getJSON('/answers/like', {answerId : answerId}, function(likes) {
            $('div.answer-likes-' + answerId).find('span').text(likes);
        });
    };

    questionGetAjax.answerDislike = function(answerId) {
        $.getJSON('/answers/dislike', {answerId : answerId}, function(likes) {
            $('div.answer-likes-' + answerId).find('span').text(likes);
        });
    };

    return questionGetAjax;
})(questionGetAjax || {});
