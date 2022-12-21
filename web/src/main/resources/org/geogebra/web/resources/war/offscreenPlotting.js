self.onmessage = (evt) => {
  console.log(evt.data);
  const canvas = evt.data.canvas;
//  const view = evt.data.view;
//  const gp = evt.data.gp;
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
