function MainMenuGui(params) {
    this.options = {
        $element: $('.main-menu')
    };
    $.extend(true, this.options, params);


    this._resizeButtons = function(event){
        event.data.that.options.$element.children('div').each(function(i,o){
            $(o).height($(o).width());
        });
    };

    this._initListeners = function(){
        $(window).on('resize', {that: this}, this._resizeButtons);
    };

    this.init = function(){
        this._resizeButtons({data:{that:this}});
        this._initListeners();
    }

    this.init();
}