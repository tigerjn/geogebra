self.window = function() {};
importScripts('jsonfn.js');
self.onmessage = (evt) => {
  console.log(evt.data);
  const canvas = evt.data.canvas;
  const fn = JSONfn.parse(evt.data.evalFn);
  console.log(fn(3));
  var count = 0;

function view() {};

view.real2viewCoords = function(a,b) {
	return {x: a/3, y: b/3};
};

function gp() {

    this.currentX = NaN;
    this.currentY = NaN;


};

    gp.moveTo = function(x, y) {
        ctx.moveTo(x, y);
        this.currentX = x;
        this.currentY = y;
    }

    gp.lineTo = function(x, y) {
	count++;
	    ctx.lineTo(x, y);
        this.currentX = x;
        this.currentY = y;
    }

    gp.getCurrentPoint = function() {
        return [this.currentX, this.currentY];
    }


  const ctx = canvas.getContext("2d");
  ctx.beginPath();
  ctx.moveTo(0,0);
  ctx.lineTo(1000, 1000);
  ctx.stroke();

//
//  function draw(y) {
//
//	count = 0;
//	ctx.translate(y,y);
//    ctx.beginPath();
//    geogebra_src_DrawParametricCurve_plotInterval__Lgeogebra_src_ParametricCurve_2DDIDLgeogebra_src_EuclidianView_2Lgeogebra_src_GeneralPathClipped_2ZLgeogebra_src_DrawParametricCurve$Gap_2Lgeogebra_src_GPoint_2(curve, 0, 1920, 0, 1, view, gp, true, 1);
//
//    ctx.stroke();
//
//	console.log(count);
//
//	count = 0;
//
//    ctx.beginPath();
//    ctx.stroke();
//	}
//
//  	for (let i=0; i < 1000; i = i+10) {
//    	  draw(i);
//    }
//	console.log(count);
}
