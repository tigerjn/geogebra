    var $gwt_version = "2.5.1";
    var $wnd = parent;
    var $doc = $wnd.document;
    var $moduleName, $moduleBase;
    var $strongName = 'E44C1F47A541B495B55C565E3B0AD30E';
    var $stats = $wnd.__gwtStatsEvent ? function(a) {return $wnd.__gwtStatsEvent(a);} : null,
    $sessionId = $wnd.__gwtStatsSessionId ? $wnd.__gwtStatsSessionId : null;
    $stats && $stats({moduleName:'drawparametriccurve',sessionId:$sessionId,subSystem:'startup',evtGroup:'moduleStartup',millis:(new Date()).getTime(),type:'moduleEvalStart'});

        var $intern_11 = '', $intern_1 = 'CSS1Compat', $intern_10 = 'com.google.gwt.core.client.', $intern_14 = 'com.google.gwt.core.client.impl.', $intern_12 = 'com.google.gwt.lang.', $intern_13 = 'geogebra.src.', $intern_9 = 'java.lang.', $intern_3 = 'msie', $intern_2 = 'opera', $intern_7 = 'public RealRootFunction getRealRootFunctionX()', $intern_8 = 'public RealRootFunction getRealRootFunctionY()', $intern_6 = 'public void evaluateCurve(double t1, double[] eval)', $intern_4 = 'public void lineTo(double x, double y)', $intern_5 = 'public void moveTo(double x, double y)', $intern_0 = 'safari';
        var _, P0_longLit = {l:0, m:0, h:0}, P1_longLit = {l:1, m:0, h:0}, com_google_gwt_lang_SeedUtil_seedTable = {}, Q$java_lang_Object = 0, Q$java_lang_String = 1, Q$java_lang_Throwable = 2, CM$ = {};
        function com_google_gwt_lang_SeedUtil_newSeed__ILcom_google_gwt_core_client_JavaScriptObject_2(id){
            return new com_google_gwt_lang_SeedUtil_seedTable[id];
            }

        function com_google_gwt_lang_SeedUtil_defineSeed__IILcom_google_gwt_core_client_JavaScriptObject_2Lcom_google_gwt_core_client_JavaScriptObject_2(id, superSeed, castableTypeMap){
            var seed = com_google_gwt_lang_SeedUtil_seedTable[id];
            if (seed && !seed.java_lang_Object__1_1_1clazz$) {
            _ = seed.prototype;
            }
        else {
            !seed && (seed = com_google_gwt_lang_SeedUtil_seedTable[id] = function(){
            }
        );
        _ = seed.prototype = superSeed < 0?{}:com_google_gwt_lang_SeedUtil_newSeed__ILcom_google_gwt_core_client_JavaScriptObject_2(superSeed);
            _.java_lang_Object_castableTypeMap$ = castableTypeMap;
            }
            for (var i = 3; i < arguments.length; ++i) {
                    arguments[i].prototype = _;
                    }
                if (seed.java_lang_Object__1_1_1clazz$) {
                    _.java_lang_Object__1_1_1clazz$ = seed.java_lang_Object__1_1_1clazz$;
                    seed.java_lang_Object__1_1_1clazz$ = null;
                    }
                }

                function makeCastMap(a){
                    var result = {};
                for (var i = 0, c = a.length; i < c; ++i) {
                        result[a[i]] = 1;
                        }
                    return result;
                    }

                    function nullMethod(){
                        }

                    com_google_gwt_lang_SeedUtil_defineSeed__IILcom_google_gwt_core_client_JavaScriptObject_2Lcom_google_gwt_core_client_JavaScriptObject_2(1, -1, CM$);
                    com_google_gwt_lang_SeedUtil_defineSeed__IILcom_google_gwt_core_client_JavaScriptObject_2Lcom_google_gwt_core_client_JavaScriptObject_2(8, 1, makeCastMap([Q$java_lang_Throwable]));
                    com_google_gwt_lang_SeedUtil_defineSeed__IILcom_google_gwt_core_client_JavaScriptObject_2Lcom_google_gwt_core_client_JavaScriptObject_2(7, 8, makeCastMap([Q$java_lang_Throwable]));
                    com_google_gwt_lang_SeedUtil_defineSeed__IILcom_google_gwt_core_client_JavaScriptObject_2Lcom_google_gwt_core_client_JavaScriptObject_2(6, 7, makeCastMap([Q$java_lang_Throwable]));
                    function com_google_gwt_core_client_JavaScriptException_JavaScriptException__Ljava_lang_Object_2V(e){
                        }

                    com_google_gwt_lang_SeedUtil_defineSeed__IILcom_google_gwt_core_client_JavaScriptObject_2Lcom_google_gwt_core_client_JavaScriptObject_2(5, 6, makeCastMap([Q$java_lang_Throwable]), com_google_gwt_core_client_JavaScriptException_JavaScriptException__Ljava_lang_Object_2V);
                    com_google_gwt_lang_SeedUtil_defineSeed__IILcom_google_gwt_core_client_JavaScriptObject_2Lcom_google_gwt_core_client_JavaScriptObject_2(11, 1, {});
                    function com_google_gwt_core_client_impl_Impl_apply__Ljava_lang_Object_2Ljava_lang_Object_2Ljava_lang_Object_2Ljava_lang_Object_2(jsFunction, thisObj, args){
                        return jsFunction.apply(thisObj, args);
                        var _;
                        }

                    function com_google_gwt_core_client_impl_Impl_enter__Z(){
                        var now;
                        if (com_google_gwt_core_client_impl_Impl_entryDepth != 0) {
                        now = (new Date).getTime();
                        if (now - com_google_gwt_core_client_impl_Impl_watchdogEntryDepthLastScheduled > 2000) {
                        com_google_gwt_core_client_impl_Impl_watchdogEntryDepthLastScheduled = now;
                        com_google_gwt_core_client_impl_Impl_watchdogEntryDepthTimerId = com_google_gwt_core_client_impl_Impl_watchdogEntryDepthSchedule__I();
                        }
                    }
                    if (com_google_gwt_core_client_impl_Impl_entryDepth++ == 0) {
                        com_google_gwt_core_client_impl_SchedulerImpl_$flushEntryCommands__Lcom_google_gwt_core_client_impl_SchedulerImpl_2V((com_google_gwt_core_client_impl_SchedulerImpl_$clinit__V() , com_google_gwt_core_client_impl_SchedulerImpl_INSTANCE));
                        return true;
                        }
                    return false;
                    }

                    function com_google_gwt_core_client_impl_Impl_entry__Lcom_google_gwt_core_client_JavaScriptObject_2Lcom_google_gwt_core_client_JavaScriptObject_2(jsFunction){
                        return function(){
                        try {
                        return com_google_gwt_core_client_impl_Impl_entry0__Ljava_lang_Object_2Ljava_lang_Object_2Ljava_lang_Object_2Ljava_lang_Object_2(jsFunction, this, arguments);
                        }
                    catch (e) {
                        throw e;
                        }
                    }
                    ;
                    }

                    function com_google_gwt_core_client_impl_Impl_entry0__Ljava_lang_Object_2Ljava_lang_Object_2Ljava_lang_Object_2Ljava_lang_Object_2(jsFunction, thisObj, args){
                        var initialEntry;
                        initialEntry = com_google_gwt_core_client_impl_Impl_enter__Z();
                        try {
                        return com_google_gwt_core_client_impl_Impl_apply__Ljava_lang_Object_2Ljava_lang_Object_2Ljava_lang_Object_2Ljava_lang_Object_2(jsFunction, thisObj, args);
                        }
                    finally {
                        com_google_gwt_core_client_impl_Impl_exit__ZV(initialEntry);
                        }
                    }

                    function com_google_gwt_core_client_impl_Impl_exit__ZV(initialEntry){
                        initialEntry && com_google_gwt_core_client_impl_SchedulerImpl_$flushFinallyCommands__Lcom_google_gwt_core_client_impl_SchedulerImpl_2V((com_google_gwt_core_client_impl_SchedulerImpl_$clinit__V() , com_google_gwt_core_client_impl_SchedulerImpl_INSTANCE));
                        --com_google_gwt_core_client_impl_Impl_entryDepth;
                        if (initialEntry) {
                        if (com_google_gwt_core_client_impl_Impl_watchdogEntryDepthTimerId != -1) {
                        com_google_gwt_core_client_impl_Impl_watchdogEntryDepthCancel__IV(com_google_gwt_core_client_impl_Impl_watchdogEntryDepthTimerId);
                        com_google_gwt_core_client_impl_Impl_watchdogEntryDepthTimerId = -1;
                        }
                    }
                    }

                    function com_google_gwt_core_client_impl_Impl_watchdogEntryDepthCancel__IV(timerId){
                        $wnd.clearTimeout(timerId);
                        }

                    function com_google_gwt_core_client_impl_Impl_watchdogEntryDepthSchedule__I(){
                        return $wnd.setTimeout(function(){
                        com_google_gwt_core_client_impl_Impl_entryDepth != 0 && (com_google_gwt_core_client_impl_Impl_entryDepth = 0);
                        com_google_gwt_core_client_impl_Impl_watchdogEntryDepthTimerId = -1;
                        }
                    , 10);
                    }

                    var com_google_gwt_core_client_impl_Impl_entryDepth = 0, com_google_gwt_core_client_impl_Impl_watchdogEntryDepthLastScheduled = 0, com_google_gwt_core_client_impl_Impl_watchdogEntryDepthTimerId = -1;
                    function com_google_gwt_core_client_impl_SchedulerImpl_$clinit__V(){
                        com_google_gwt_core_client_impl_SchedulerImpl_$clinit__V = nullMethod;
                        com_google_gwt_core_client_impl_SchedulerImpl_INSTANCE = new com_google_gwt_core_client_impl_SchedulerImpl_SchedulerImpl__V;
                        }

                    function com_google_gwt_core_client_impl_SchedulerImpl_$flushEntryCommands__Lcom_google_gwt_core_client_impl_SchedulerImpl_2V(this$static){
                        var oldQueue, rescheduled;
                        if (this$static.com_google_gwt_core_client_impl_SchedulerImpl_entryCommands) {
                        rescheduled = null;
                        do {
                        oldQueue = this$static.com_google_gwt_core_client_impl_SchedulerImpl_entryCommands;
                        this$static.com_google_gwt_core_client_impl_SchedulerImpl_entryCommands = null;
                        rescheduled = com_google_gwt_core_client_impl_SchedulerImpl_runScheduledTasks__Lcom_google_gwt_core_client_JsArray_2Lcom_google_gwt_core_client_JsArray_2Lcom_google_gwt_core_client_JsArray_2(oldQueue, rescheduled);
                        }
                    while (this$static.com_google_gwt_core_client_impl_SchedulerImpl_entryCommands);
                    this$static.com_google_gwt_core_client_impl_SchedulerImpl_entryCommands = rescheduled;
                    }
                    }

                    function com_google_gwt_core_client_impl_SchedulerImpl_$flushFinallyCommands__Lcom_google_gwt_core_client_impl_SchedulerImpl_2V(this$static){
                        var oldQueue, rescheduled;
                        if (this$static.com_google_gwt_core_client_impl_SchedulerImpl_finallyCommands) {
                        rescheduled = null;
                        do {
                        oldQueue = this$static.com_google_gwt_core_client_impl_SchedulerImpl_finallyCommands;
                        this$static.com_google_gwt_core_client_impl_SchedulerImpl_finallyCommands = null;
                        rescheduled = com_google_gwt_core_client_impl_SchedulerImpl_runScheduledTasks__Lcom_google_gwt_core_client_JsArray_2Lcom_google_gwt_core_client_JsArray_2Lcom_google_gwt_core_client_JsArray_2(oldQueue, rescheduled);
                        }
                    while (this$static.com_google_gwt_core_client_impl_SchedulerImpl_finallyCommands);
                    this$static.com_google_gwt_core_client_impl_SchedulerImpl_finallyCommands = rescheduled;
                    }
                    }

                    function com_google_gwt_core_client_impl_SchedulerImpl_SchedulerImpl__V(){
                        }

                    function com_google_gwt_core_client_impl_SchedulerImpl_push__Lcom_google_gwt_core_client_JsArray_2Lcom_google_gwt_core_client_impl_SchedulerImpl$Task_2Lcom_google_gwt_core_client_JsArray_2(queue, task){
                        !queue && (queue = []);
                        queue[queue.length] = task;
                        return queue;
                        }

                    function com_google_gwt_core_client_impl_SchedulerImpl_runScheduledTasks__Lcom_google_gwt_core_client_JsArray_2Lcom_google_gwt_core_client_JsArray_2Lcom_google_gwt_core_client_JsArray_2(tasks, rescheduled){
                        var i, j, t;
                        for (i = 0 , j = tasks.length; i < j; ++i) {
                        t = tasks[i];
                        try {
                        t[1]?t[0].nullMethod() && (rescheduled = com_google_gwt_core_client_impl_SchedulerImpl_push__Lcom_google_gwt_core_client_JsArray_2Lcom_google_gwt_core_client_impl_SchedulerImpl$Task_2Lcom_google_gwt_core_client_JsArray_2(rescheduled, t)):t[0].nullMethod();
                        }
                    catch ($e0) {
                        $e0 = com_google_gwt_lang_Exceptions_caught__Ljava_lang_Object_2Ljava_lang_Object_2($e0);
                        if (!com_google_gwt_lang_Cast_instanceOf__Ljava_lang_Object_2IZ($e0, Q$java_lang_Throwable))
                        throw $e0;
                        }
                    }
                    return rescheduled;
                    }

                    com_google_gwt_lang_SeedUtil_defineSeed__IILcom_google_gwt_core_client_JavaScriptObject_2Lcom_google_gwt_core_client_JavaScriptObject_2(13, 11, {}, com_google_gwt_core_client_impl_SchedulerImpl_SchedulerImpl__V);
                    _.com_google_gwt_core_client_impl_SchedulerImpl_entryCommands = null;
                    _.com_google_gwt_core_client_impl_SchedulerImpl_finallyCommands = null;
                    var com_google_gwt_core_client_impl_SchedulerImpl_INSTANCE;
                    com_google_gwt_lang_SeedUtil_defineSeed__IILcom_google_gwt_core_client_JavaScriptObject_2Lcom_google_gwt_core_client_JavaScriptObject_2(15, 1, {});
                    function com_google_gwt_core_client_impl_StringBufferImplAppend_StringBufferImplAppend__V(){
                        }

                    com_google_gwt_lang_SeedUtil_defineSeed__IILcom_google_gwt_core_client_JavaScriptObject_2Lcom_google_gwt_core_client_JavaScriptObject_2(16, 15, {}, com_google_gwt_core_client_impl_StringBufferImplAppend_StringBufferImplAppend__V);
                    function com_google_gwt_lang_Array_Array__V(){
                        }

                    function com_google_gwt_lang_Array_createFromSeed__IILcom_google_gwt_lang_Array_2(seedType, length){
                        var array = new Array(length);
                        if (seedType == 3) {
                        for (var i = 0; i < length; ++i) {
                        var value = new Object;
                        value.l = value.m = value.h = 0;
                        array[i] = value;
                        }
                    }
                    else if (seedType > 0) {
                        var value = [null, 0, false][seedType];
                        for (var i = 0; i < length; ++i) {
                        array[i] = value;
                        }
                    }
                    return array;
                    }

                    function com_google_gwt_lang_Array_initDim__Ljava_lang_Class_2Lcom_google_gwt_core_client_JavaScriptObject_2IIILcom_google_gwt_lang_Array_2(arrayClass, castableTypeMap, queryId, length, seedType){
                        var result;
                        result = com_google_gwt_lang_Array_createFromSeed__IILcom_google_gwt_lang_Array_2(seedType, length);
                        com_google_gwt_lang_Array_initValues__Ljava_lang_Class_2Lcom_google_gwt_core_client_JavaScriptObject_2ILcom_google_gwt_lang_Array_2Lcom_google_gwt_lang_Array_2(arrayClass, castableTypeMap, queryId, result);
                        return result;
                        }

                    function com_google_gwt_lang_Array_initValues__Ljava_lang_Class_2Lcom_google_gwt_core_client_JavaScriptObject_2ILcom_google_gwt_lang_Array_2Lcom_google_gwt_lang_Array_2(arrayClass, castableTypeMap, queryId, array){
                        com_google_gwt_lang_Array$ExpandoWrapper_$clinit__V();
                        com_google_gwt_lang_Array$ExpandoWrapper_wrapArray__Lcom_google_gwt_lang_Array_2Ljava_lang_Object_2Ljava_lang_Object_2V(array, com_google_gwt_lang_Array$ExpandoWrapper_expandoNames, com_google_gwt_lang_Array$ExpandoWrapper_expandoValues);
                        array.java_lang_Object__1_1_1clazz$ = arrayClass;
                        array.java_lang_Object_castableTypeMap$ = castableTypeMap;
                        return array;
                        }

                    com_google_gwt_lang_SeedUtil_defineSeed__IILcom_google_gwt_core_client_JavaScriptObject_2Lcom_google_gwt_core_client_JavaScriptObject_2(19, 1, {}, com_google_gwt_lang_Array_Array__V);
                    function com_google_gwt_lang_Array$ExpandoWrapper_$clinit__V(){
                        com_google_gwt_lang_Array$ExpandoWrapper_$clinit__V = nullMethod;
                        com_google_gwt_lang_Array$ExpandoWrapper_expandoNames = [];
                        com_google_gwt_lang_Array$ExpandoWrapper_expandoValues = [];
                        com_google_gwt_lang_Array$ExpandoWrapper_initExpandos__Lcom_google_gwt_lang_Array_2Ljava_lang_Object_2Ljava_lang_Object_2V(new com_google_gwt_lang_Array_Array__V, com_google_gwt_lang_Array$ExpandoWrapper_expandoNames, com_google_gwt_lang_Array$ExpandoWrapper_expandoValues);
                        }

                    function com_google_gwt_lang_Array$ExpandoWrapper_initExpandos__Lcom_google_gwt_lang_Array_2Ljava_lang_Object_2Ljava_lang_Object_2V(protoType, expandoNames, expandoValues){
                        var i = 0, value;
                        for (var name in protoType) {
                        if (value = protoType[name]) {
                        expandoNames[i] = name;
                        expandoValues[i] = value;
                        ++i;
                        }
                    }
                    }

                    function com_google_gwt_lang_Array$ExpandoWrapper_wrapArray__Lcom_google_gwt_lang_Array_2Ljava_lang_Object_2Ljava_lang_Object_2V(array, expandoNames, expandoValues){
                        com_google_gwt_lang_Array$ExpandoWrapper_$clinit__V();
                        for (var i = 0, c = expandoNames.length; i < c; ++i) {
                        array[expandoNames[i]] = expandoValues[i];
                        }
                    }

                    var com_google_gwt_lang_Array$ExpandoWrapper_expandoNames, com_google_gwt_lang_Array$ExpandoWrapper_expandoValues;
                    function com_google_gwt_lang_Cast_instanceOf__Ljava_lang_Object_2IZ(src, dstId){
                        return src != null && src.java_lang_Object_castableTypeMap$ && !!src.java_lang_Object_castableTypeMap$[dstId];
                        }

                    function com_google_gwt_lang_Cast_round_1int__DI(x){
                        return ~~Math.max(Math.min(x, 2147483647), -2147483648);
                        }

                    function com_google_gwt_lang_EntryMethodHolder_init__V(){
                        var com_google_gwt_useragent_client_UserAgentAsserter_$onModuleLoad__Lcom_google_gwt_useragent_client_UserAgentAsserter_2V_runtimeValue_0, geogebra_src_Main_$onModuleLoad__Lgeogebra_src_Main_2V_out_0, geogebra_src_Main_$onModuleLoad__Lgeogebra_src_Main_2V_x_0, geogebra_src_Main_$onModuleLoad__Lgeogebra_src_Main_2V_y_0;
                        !!$stats && com_google_gwt_lang_Stats_onModuleStart__Ljava_lang_String_2Z('com.google.gwt.useragent.client.UserAgentAsserter');
                        com_google_gwt_useragent_client_UserAgentAsserter_$onModuleLoad__Lcom_google_gwt_useragent_client_UserAgentAsserter_2V_runtimeValue_0 = com_google_gwt_useragent_client_UserAgentAsserter_1UserAgentPropertyImplSafari_$getRuntimeValue__Lcom_google_gwt_useragent_client_UserAgentAsserter_1UserAgentPropertyImplSafari_2Ljava_lang_String_2();
                        java_lang_String_$equals__Ljava_lang_String_2Ljava_lang_Object_2Z($intern_0, com_google_gwt_useragent_client_UserAgentAsserter_$onModuleLoad__Lcom_google_gwt_useragent_client_UserAgentAsserter_2V_runtimeValue_0) || ($wnd.alert('ERROR: Possible problem with your *.gwt.xml module file.\nThe compile time user.agent value (safari) does not match the runtime user.agent value (' + com_google_gwt_useragent_client_UserAgentAsserter_$onModuleLoad__Lcom_google_gwt_useragent_client_UserAgentAsserter_2V_runtimeValue_0 + '). Expect more errors.\n') , undefined);
                        !!$stats && com_google_gwt_lang_Stats_onModuleStart__Ljava_lang_String_2Z('com.google.gwt.user.client.DocumentModeAsserter');
                        com_google_gwt_user_client_DocumentModeAsserter_$onModuleLoad__Lcom_google_gwt_user_client_DocumentModeAsserter_2V();
                        !!$stats && com_google_gwt_lang_Stats_onModuleStart__Ljava_lang_String_2Z('geogebra.src.Main');
                        new geogebra_src_DrawParametricCurve_DrawParametricCurve__V;
                        geogebra_src_DrawParametricCurve_plotCurve__Lgeogebra_src_ParametricCurve_2DDLgeogebra_src_EuclidianView_2Lgeogebra_src_GeneralPathClipped_2ZLgeogebra_src_DrawParametricCurve$Gap_2Lgeogebra_src_GPoint_2(new geogebra_src_ParametricCurve_ParametricCurve__IV, new geogebra_src_EuclidianView_EuclidianView__IV, new geogebra_src_GeneralPathClipped_GeneralPathClipped__IV);
                        geogebra_src_Main_$onModuleLoad__Lgeogebra_src_Main_2V_out_0 = new org_apache_commons_math_complex_Complex_Complex__DDV(3, 4);
                        geogebra_src_Main_$onModuleLoad__Lgeogebra_src_Main_2V_out_0 = org_apache_commons_math_complex_Complex_$divide__Lorg_apache_commons_math_complex_Complex_2Lorg_apache_commons_math_complex_Complex_2Lorg_apache_commons_math_complex_Complex_2((org_apache_commons_math_complex_Complex_$clinit__V() , org_apache_commons_math_complex_Complex_ONE), org_apache_commons_math_complex_Complex_$sinh__Lorg_apache_commons_math_complex_Complex_2Lorg_apache_commons_math_complex_Complex_2(geogebra_src_Main_$onModuleLoad__Lgeogebra_src_Main_2V_out_0));
                        geogebra_src_Main_$onModuleLoad__Lgeogebra_src_Main_2V_x_0 = geogebra_src_Main_$onModuleLoad__Lgeogebra_src_Main_2V_out_0.org_apache_commons_math_complex_Complex_real;
                        geogebra_src_Main_$onModuleLoad__Lgeogebra_src_Main_2V_y_0 = geogebra_src_Main_$onModuleLoad__Lgeogebra_src_Main_2V_out_0.org_apache_commons_math_complex_Complex_imaginary;
                        geogebra_src_App_debug__Ljava_lang_String_2V('1/(3+4i)=' + geogebra_src_Main_$onModuleLoad__Lgeogebra_src_Main_2V_x_0 + ' +i' + geogebra_src_Main_$onModuleLoad__Lgeogebra_src_Main_2V_y_0);
                        geogebra_src_App_debug__Ljava_lang_String_2V('finished');
                        }

                    function com_google_gwt_lang_Exceptions_caught__Ljava_lang_Object_2Ljava_lang_Object_2(e){
                        if (com_google_gwt_lang_Cast_instanceOf__Ljava_lang_Object_2IZ(e, Q$java_lang_Throwable)) {
                        return e;
                        }
                    return new com_google_gwt_core_client_JavaScriptException_JavaScriptException__Ljava_lang_Object_2V(e);
                    }

                    function com_google_gwt_lang_LongLib_add__Lcom_google_gwt_lang_LongLibBase$LongEmul_2Lcom_google_gwt_lang_LongLibBase$LongEmul_2Lcom_google_gwt_lang_LongLibBase$LongEmul_2(a, b){
                        var sum0, sum1, sum2;
                        sum0 = a.l + b.l;
                        sum1 = a.m + b.m + (~~sum0 >> 22);
                        sum2 = a.h + b.h + (~~sum1 >> 22);
                        return _ = new com_google_gwt_lang_LongLibBase$LongEmul_LongLibBase$LongEmul__V , _.l = sum0 & 4194303 , _.m = sum1 & 4194303 , _.h = sum2 & 1048575 , _;
                        }

                    function com_google_gwt_lang_LongLibBase$LongEmul_LongLibBase$LongEmul__V(){
                        }

                    com_google_gwt_lang_SeedUtil_defineSeed__IILcom_google_gwt_core_client_JavaScriptObject_2Lcom_google_gwt_core_client_JavaScriptObject_2(27, 1, {}, com_google_gwt_lang_LongLibBase$LongEmul_LongLibBase$LongEmul__V);
                    function com_google_gwt_lang_Stats_onModuleStart__Ljava_lang_String_2Z(mainClassName){
                        return $stats({moduleName:$moduleName, sessionId:$sessionId, subSystem:'startup', evtGroup:'moduleStartup', millis:(new Date).getTime(), type:'onModuleLoadStart', className:mainClassName});
                    }

                    function com_google_gwt_user_client_DocumentModeAsserter_$onModuleLoad__Lcom_google_gwt_user_client_DocumentModeAsserter_2V(){
                        var allowedModes, currentMode, i;
                        currentMode = $doc.compatMode;
                        allowedModes = com_google_gwt_lang_Array_initValues__Ljava_lang_Class_2Lcom_google_gwt_core_client_JavaScriptObject_2ILcom_google_gwt_lang_Array_2Lcom_google_gwt_lang_Array_2(com_google_gwt_lang_ClassLiteralHolder__13Ljava_1lang_1String_12_1classLit, CM$, Q$java_lang_String, [$intern_1]);
                        for (i = 0; i < allowedModes.length; ++i) {
                        if (java_lang_String_$equals__Ljava_lang_String_2Ljava_lang_Object_2Z(allowedModes[i], currentMode)) {
                        return;
                        }
                    }
                    allowedModes.length == 1 && java_lang_String_$equals__Ljava_lang_String_2Ljava_lang_Object_2Z($intern_1, allowedModes[0]) && java_lang_String_$equals__Ljava_lang_String_2Ljava_lang_Object_2Z('BackCompat', currentMode)?"GWT no longer supports Quirks Mode (document.compatMode=' BackCompat').<br>Make sure your application's host HTML page has a Standards Mode (document.compatMode=' CSS1Compat') doctype,<br>e.g. by using &lt;!doctype html&gt; at the start of your application's HTML page.<br><br>To continue using this unsupported rendering mode and risk layout problems, suppress this message by adding<br>the following line to your*.gwt.xml module file:<br>&nbsp;&nbsp;&lt;extend-configuration-property name=\"document.compatMode\" value=\"" + currentMode + '"/&gt;':"Your *.gwt.xml module configuration prohibits the use of the current doucment rendering mode (document.compatMode=' " + currentMode + "').<br>Modify your application's host HTML page doctype, or update your custom 'document.compatMode' configuration property settings.";
                        }

                        function com_google_gwt_useragent_client_UserAgentAsserter_1UserAgentPropertyImplSafari_$getRuntimeValue__Lcom_google_gwt_useragent_client_UserAgentAsserter_1UserAgentPropertyImplSafari_2Ljava_lang_String_2(){
                            var ua = navigator.userAgent.toLowerCase();
                            var makeVersion = function(result){
                            return parseInt(result[1]) * 1000 + parseInt(result[2]);
                            }
                        ;
                        if (function(){
                            return ua.indexOf($intern_2) != -1;
                            }
                        ())
                        return $intern_2;
                        if (function(){
                            return ua.indexOf('webkit') != -1;
                            }
                        ())
                        return $intern_0;
                        if (function(){
                            return ua.indexOf($intern_3) != -1 && $doc.documentMode >= 9;
                            }
                        ())
                        return 'ie9';
                        if (function(){
                            return ua.indexOf($intern_3) != -1 && $doc.documentMode >= 8;
                            }
                        ())
                        return 'ie8';
                        if (function(){
                            var result = /msie ([0-9]+)\.([0-9]+)/.exec(ua);
                            if (result && result.length == 3)
                            return makeVersion(result) >= 6000;
                            }
                        ())
                        return 'ie6';
                        if (function(){
                            return ua.indexOf('gecko') != -1;
                            }
                        ())
                        return 'gecko1_8';
                        return 'unknown';
                        }

                        function geogebra_src_App_debug__Ljava_lang_String_2V(s){
                            !$wnd.console && ($wnd.console = {});
                        !$wnd.console.log && ($wnd.console.log = function(){
                            }
                        );
                        $wnd.console.log(s);
                        }

                        function geogebra_src_DrawParametricCurve_$clinit__V(){
                            geogebra_src_DrawParametricCurve_$clinit__V = nullMethod;
                            geogebra_src_DrawParametricCurve_MAX_1BEND = Math.tan(0.17453292519943295);
                            geogebra_src_DrawParametricCurve_MAX_1BEND_1OFF_1SCREEN = Math.tan(0.7853981633974483);
                            }

                        function geogebra_src_DrawParametricCurve_DrawParametricCurve__V(){
                            geogebra_src_DrawParametricCurve_$clinit__V();
                            new java_lang_StringBuilder_StringBuilder__V;
                            }

                        function geogebra_src_DrawParametricCurve_corner__Lgeogebra_src_GeneralPathClipped_2DDLgeogebra_src_EuclidianView_2V(gp2, x0, y0, view){
                            var h, pt, w, x, y;
                            w = geogebra_src_EuclidianView_$getWidth__Lgeogebra_src_EuclidianView_2I(view);
                            h = geogebra_src_EuclidianView_$getHeight__Lgeogebra_src_EuclidianView_2I(view);
                            pt = geogebra_src_GeneralPathClipped_$getCurrentPoint__Lgeogebra_src_GeneralPathClipped_2Lgeogebra_src_GPoint_2(gp2);
                            if (!pt) {
                            return;
                            }
                        x = pt.geogebra_src_GPoint_x;
                        y = pt.geogebra_src_GPoint_y;
                        if (x < 0 && x0 > w || x > w && x0 < 0) {
                                geogebra_src_DrawParametricCurve_drawTo__Lgeogebra_src_GeneralPathClipped_2DDZV(gp2, x, -10, true);
                                geogebra_src_DrawParametricCurve_drawTo__Lgeogebra_src_GeneralPathClipped_2DDZV(gp2, x0, -10, true);
                                return;
                                }
                            if (y < 0 && y0 > h || y > h && y0 < 0) {
                                    geogebra_src_DrawParametricCurve_drawTo__Lgeogebra_src_GeneralPathClipped_2DDZV(gp2, -10, y, true);
                                    geogebra_src_DrawParametricCurve_drawTo__Lgeogebra_src_GeneralPathClipped_2DDZV(gp2, -10, y0, true);
                                    return;
                                    }
                                if ((x > w || x < 0) && (y0 < 0 || y0 > h)) {
                                        geogebra_src_DrawParametricCurve_drawTo__Lgeogebra_src_GeneralPathClipped_2DDZV(gp2, x, y0, true);
                                        return;
                                        }
                                    if ((x0 > w || x0 < 0) && (y < 0 || y > h)) {
                                            geogebra_src_DrawParametricCurve_drawTo__Lgeogebra_src_GeneralPathClipped_2DDZV(gp2, x0, y, true);
                                            return;
                                            }
                                        }

                                        function geogebra_src_DrawParametricCurve_drawTo__Lgeogebra_src_GeneralPathClipped_2DDZV(gp, x, y, lineTo){
                                            var point;
                                            point = geogebra_src_GeneralPathClipped_$getCurrentPoint__Lgeogebra_src_GeneralPathClipped_2Lgeogebra_src_GPoint_2(gp);
                                            if (!point) {
                                            geogebra_src_GeneralPathClipped_$moveTo__Lgeogebra_src_GeneralPathClipped_2DDV(gp, x, y);
                                            ++geogebra_src_DrawParametricCurve_countPoints;
                                            }
                                        else if (!geogebra_src_Kernel_isEqual__DDDZ(x, point.geogebra_src_GPoint_x, 0.5) || !geogebra_src_Kernel_isEqual__DDDZ(y, point.geogebra_src_GPoint_y, 0.5)) {
                                            lineTo?geogebra_src_GeneralPathClipped_$lineTo__Lgeogebra_src_GeneralPathClipped_2DDV(gp, x, y):geogebra_src_GeneralPathClipped_$moveTo__Lgeogebra_src_GeneralPathClipped_2DDV(gp, x, y);
                                            ++geogebra_src_DrawParametricCurve_countPoints;
                                            }
                                        }

                                        function geogebra_src_DrawParametricCurve_getDefinedInterval__Lgeogebra_src_ParametricCurve_2DD_3DZ(curve, a, b, borders){
                                            var aDef, bDef, intervalX, intervalY, lowerBound, upperBound;
                                            geogebra_src_ParametricCurve_$evaluateCurve__Lgeogebra_src_ParametricCurve_2D_3DV(curve, a, borders);
                                            geogebra_src_DrawParametricCurve_countEvaluations = com_google_gwt_lang_LongLib_add__Lcom_google_gwt_lang_LongLibBase$LongEmul_2Lcom_google_gwt_lang_LongLibBase$LongEmul_2Lcom_google_gwt_lang_LongLibBase$LongEmul_2(geogebra_src_DrawParametricCurve_countEvaluations, P1_longLit);
                                            aDef = !geogebra_src_DrawParametricCurve_isUndefined__DZ(borders[0]) && !geogebra_src_DrawParametricCurve_isUndefined__DZ(borders[1]);
                                            geogebra_src_ParametricCurve_$evaluateCurve__Lgeogebra_src_ParametricCurve_2D_3DV(curve, b, borders);
                                            geogebra_src_DrawParametricCurve_countEvaluations = com_google_gwt_lang_LongLib_add__Lcom_google_gwt_lang_LongLibBase$LongEmul_2Lcom_google_gwt_lang_LongLibBase$LongEmul_2Lcom_google_gwt_lang_LongLibBase$LongEmul_2(geogebra_src_DrawParametricCurve_countEvaluations, P1_longLit);
                                            bDef = !geogebra_src_DrawParametricCurve_isUndefined__DZ(borders[0]) && !geogebra_src_DrawParametricCurve_isUndefined__DZ(borders[1]);
                                            if (aDef && bDef) {
                                            borders[0] = a;
                                            borders[1] = b;
                                            }
                                        else if (aDef && !bDef || !aDef && bDef) {
                                            intervalX = geogebra_src_RealRootUtil_getDefinedInterval__Lgeogebra_src_RealRootFunction_2DD_3D((geogebra_src_ParametricCurve_$getRealRootFunctionX__Lgeogebra_src_ParametricCurve_2Lgeogebra_src_RealRootFunction_2() , a), b);
                                            intervalY = geogebra_src_RealRootUtil_getDefinedInterval__Lgeogebra_src_RealRootFunction_2DD_3D((geogebra_src_ParametricCurve_$getRealRootFunctionY__Lgeogebra_src_ParametricCurve_2Lgeogebra_src_RealRootFunction_2(curve) , a), b);
                                            lowerBound = java_lang_Math_max__DDD(intervalX[0], intervalY[0]);
                                            upperBound = intervalX[1] < intervalY[1]?intervalX[1]:intervalY[1];
                                            borders[0] = isNaN(lowerBound) || !isFinite(lowerBound)?a:lowerBound;
                                            borders[1] = isNaN(upperBound) || !isFinite(upperBound)?b:upperBound;
                                            }
                                        else {
                                            borders[0] = a;
                                            borders[1] = b;
                                            }
                                        return !geogebra_src_DrawParametricCurve_isUndefined___3DZ(borders);
                                        }

                                        function geogebra_src_DrawParametricCurve_isAngleOK__DDDDDZ(vx, vy, wx, wy, bend){
                                            var det, innerProduct;
                                            innerProduct = vx * wx + vy * wy;
                                            if (isNaN(innerProduct) || !isFinite(innerProduct)) {
                                            return true;
                                            }
                                        else if (innerProduct <= 0) {
                                                return false;
                                                }
                                            else {
                                                det = vx * wy - vy * wx <= 0?0 - (vx * wy - vy * wx):vx * wy - vy * wx;
                                                return det < bend * innerProduct;
                                                }
                                            }

                                                    function geogebra_src_DrawParametricCurve_isContinuous__Lgeogebra_src_ParametricCurve_2DDIZ(c, from, to){
                                                        var dist, distLeft, distRight, eps, initialDistance, iterations, left, m, middle, ret, right, t1, t2;
                                                        t1 = from;
                                                        t2 = to;
                                                        if (geogebra_src_Kernel_isEqual__DDDZ(from, to, 1.0E-15))
                                                        return true;
                                                        left = com_google_gwt_lang_Array_initDim__Ljava_lang_Class_2Lcom_google_gwt_core_client_JavaScriptObject_2IIILcom_google_gwt_lang_Array_2(com_google_gwt_lang_ClassLiteralHolder__13D_1classLit, CM$, -1, 2, 1);
                                                        geogebra_src_ParametricCurve_$evaluateCurve__Lgeogebra_src_ParametricCurve_2D_3DV(c, from, left);
                                                        geogebra_src_DrawParametricCurve_countEvaluations = com_google_gwt_lang_LongLib_add__Lcom_google_gwt_lang_LongLibBase$LongEmul_2Lcom_google_gwt_lang_LongLibBase$LongEmul_2Lcom_google_gwt_lang_LongLibBase$LongEmul_2(geogebra_src_DrawParametricCurve_countEvaluations, P1_longLit);
                                                        if (geogebra_src_DrawParametricCurve_isUndefined___3DZ(left)) {
                                                        return false;
                                                        }
                                                    right = com_google_gwt_lang_Array_initDim__Ljava_lang_Class_2Lcom_google_gwt_core_client_JavaScriptObject_2IIILcom_google_gwt_lang_Array_2(com_google_gwt_lang_ClassLiteralHolder__13D_1classLit, CM$, -1, 2, 1);
                                                    geogebra_src_ParametricCurve_$evaluateCurve__Lgeogebra_src_ParametricCurve_2D_3DV(c, to, right);
                                                    geogebra_src_DrawParametricCurve_countEvaluations = com_google_gwt_lang_LongLib_add__Lcom_google_gwt_lang_LongLibBase$LongEmul_2Lcom_google_gwt_lang_LongLibBase$LongEmul_2Lcom_google_gwt_lang_LongLibBase$LongEmul_2(geogebra_src_DrawParametricCurve_countEvaluations, P1_longLit);
                                                    if (geogebra_src_DrawParametricCurve_isUndefined___3DZ(right)) {
                                                        return false;
                                                        }
                                                    initialDistance = java_lang_Math_max__DDD(java_lang_Math_abs__DD(left[0] - right[0]), java_lang_Math_abs__DD(left[1] - right[1]));
                                                    eps = initialDistance * 0.9;
                                                    dist = Infinity;
                                                    iterations = 0;
                                                    middle = com_google_gwt_lang_Array_initDim__Ljava_lang_Class_2Lcom_google_gwt_core_client_JavaScriptObject_2IIILcom_google_gwt_lang_Array_2(com_google_gwt_lang_ClassLiteralHolder__13D_1classLit, CM$, -1, 2, 1);
                                                    while (iterations++ < 8 && dist > eps) {
                                                            m = (t1 + t2) / 2;
                                                            geogebra_src_ParametricCurve_$evaluateCurve__Lgeogebra_src_ParametricCurve_2D_3DV(c, m, middle);
                                                            geogebra_src_DrawParametricCurve_countEvaluations = com_google_gwt_lang_LongLib_add__Lcom_google_gwt_lang_LongLibBase$LongEmul_2Lcom_google_gwt_lang_LongLibBase$LongEmul_2Lcom_google_gwt_lang_LongLibBase$LongEmul_2(geogebra_src_DrawParametricCurve_countEvaluations, P1_longLit);
                                                            distLeft = java_lang_Math_max__DDD(java_lang_Math_abs__DD(left[0] - middle[0]), java_lang_Math_abs__DD(left[1] - middle[1]));
                                                            distRight = java_lang_Math_max__DDD(java_lang_Math_abs__DD(right[0] - middle[0]), java_lang_Math_abs__DD(right[1] - middle[1]));
                                                            if (distLeft > distRight) {
                                                            dist = distLeft;
                                                            t2 = m;
                                                            }
                                                        else {
                                                            dist = distRight;
                                                            t1 = m;
                                                            }
                                                        if (geogebra_src_Kernel_isEqual__DDDZ(t1, t2, 1.0E-15))
                                                        return true;
                                                        }
                                                        ret = dist <= eps;
                                                            return ret;
                                                            }

                                                            function geogebra_src_DrawParametricCurve_isDefinedAround__Lgeogebra_src_ParametricCurve_2DDZ(curve, t, eps){
                                                                var eval;
                                                                eval = com_google_gwt_lang_Array_initDim__Ljava_lang_Class_2Lcom_google_gwt_core_client_JavaScriptObject_2IIILcom_google_gwt_lang_Array_2(com_google_gwt_lang_ClassLiteralHolder__13D_1classLit, CM$, -1, 2, 1);
                                                                geogebra_src_ParametricCurve_$evaluateCurve__Lgeogebra_src_ParametricCurve_2D_3DV(curve, t + eps, eval);
                                                                geogebra_src_DrawParametricCurve_countEvaluations = com_google_gwt_lang_LongLib_add__Lcom_google_gwt_lang_LongLibBase$LongEmul_2Lcom_google_gwt_lang_LongLibBase$LongEmul_2Lcom_google_gwt_lang_LongLibBase$LongEmul_2(geogebra_src_DrawParametricCurve_countEvaluations, P1_longLit);
                                                                if (!geogebra_src_DrawParametricCurve_isUndefined___3DZ(eval)) {
                                                                geogebra_src_ParametricCurve_$evaluateCurve__Lgeogebra_src_ParametricCurve_2D_3DV(curve, t - eps, eval);
                                                                geogebra_src_DrawParametricCurve_countEvaluations = com_google_gwt_lang_LongLib_add__Lcom_google_gwt_lang_LongLibBase$LongEmul_2Lcom_google_gwt_lang_LongLibBase$LongEmul_2Lcom_google_gwt_lang_LongLibBase$LongEmul_2(geogebra_src_DrawParametricCurve_countEvaluations, P1_longLit);
                                                                if (!geogebra_src_DrawParametricCurve_isUndefined___3DZ(eval)) {
                                                                return true;
                                                                }
                                                            }
                                                            return false;
                                                            }

                                                            function geogebra_src_DrawParametricCurve_isSegmentOffScreen__Lgeogebra_src_EuclidianView_2DDDDZ(view, x1, y1, x2, y2){
                                                                if (y1 < -5 && y2 < -5)
                                                                return true;
                                                                if (x1 < -5 && x2 < -5)
                                                                return true;
                                                                if (y1 > geogebra_src_EuclidianView_$getHeight__Lgeogebra_src_EuclidianView_2I(view) + 5 && y2 > geogebra_src_EuclidianView_$getHeight__Lgeogebra_src_EuclidianView_2I(view) + 5)
                                                                return true;
                                                                if (x1 > geogebra_src_EuclidianView_$getWidth__Lgeogebra_src_EuclidianView_2I(view) + 5 && x2 > geogebra_src_EuclidianView_$getWidth__Lgeogebra_src_EuclidianView_2I(view) + 5)
                                                                return true;
                                                                return false;
                                                                }

                                                            function geogebra_src_DrawParametricCurve_isUndefined__DZ(x){
                                                                return isNaN(x) || !isFinite(x);
                                                                }

                                                            function geogebra_src_DrawParametricCurve_isUndefined___3DZ(eval){
                                                                var i;
                                                                for (i = 0; i < eval.length; ++i) {
                                                                if (geogebra_src_DrawParametricCurve_isUndefined__DZ(eval[i]))
                                                                return true;
                                                                }
                                                            return false;
                                                            }

                                                            function geogebra_src_DrawParametricCurve_plotCurve__Lgeogebra_src_ParametricCurve_2DDLgeogebra_src_EuclidianView_2Lgeogebra_src_GeneralPathClipped_2ZLgeogebra_src_DrawParametricCurve$Gap_2Lgeogebra_src_GPoint_2(curve, view, gp){
                                                                geogebra_src_DrawParametricCurve_$clinit__V();
                                                                var labelPoint;
                                                                geogebra_src_DrawParametricCurve_countPoints = 0;
                                                                geogebra_src_DrawParametricCurve_countEvaluations = P0_longLit;
                                                                labelPoint = geogebra_src_DrawParametricCurve_plotInterval__Lgeogebra_src_ParametricCurve_2DDIDLgeogebra_src_EuclidianView_2Lgeogebra_src_GeneralPathClipped_2ZLgeogebra_src_DrawParametricCurve$Gap_2Lgeogebra_src_GPoint_2(curve, 0, 1, 0, 0.0125, view, gp, true, 1);
                                                                return labelPoint;
                                                                }

                                                            function geogebra_src_DrawParametricCurve_plotInterval__Lgeogebra_src_ParametricCurve_2DDIDLgeogebra_src_EuclidianView_2Lgeogebra_src_GeneralPathClipped_2ZLgeogebra_src_DrawParametricCurve$Gap_2Lgeogebra_src_GPoint_2(curve, t1, t2, intervalDepth, max_param_step, view, gp, calcLabelPos, moveToAllowed){
                                                                var angleOK, countDiffZeros, d, depth, depthStack, distanceOK, divisors, dyadicStack, eval, i, labelPoint, left, lineTo, moveX, moveY, needLabelPos, nextLineToNeedsMoveToFirst, onScreen, onScreenStack, prevXdiff, prevYdiff, segOffScreen, singularity, t, top, x, x0, xLabel, xStack, xdiff, y, y0, yLabel, yStack, ydiff;
                                                                needLabelPos = calcLabelPos;
                                                                labelPoint = null;
                                                                moveX = 0;
                                                                moveY = 0;
                                                                nextLineToNeedsMoveToFirst = false;
                                                                eval = com_google_gwt_lang_Array_initDim__Ljava_lang_Class_2Lcom_google_gwt_core_client_JavaScriptObject_2IIILcom_google_gwt_lang_Array_2(com_google_gwt_lang_ClassLiteralHolder__13D_1classLit, CM$, -1, 2, 1);
                                                                geogebra_src_ParametricCurve_$evaluateCurve__Lgeogebra_src_ParametricCurve_2D_3DV(curve, t1, eval);
                                                                geogebra_src_DrawParametricCurve_countEvaluations = com_google_gwt_lang_LongLib_add__Lcom_google_gwt_lang_LongLibBase$LongEmul_2Lcom_google_gwt_lang_LongLibBase$LongEmul_2Lcom_google_gwt_lang_LongLibBase$LongEmul_2(geogebra_src_DrawParametricCurve_countEvaluations, P1_longLit);
                                                                geogebra_src_EuclidianView_$toScreenCoords__Lgeogebra_src_EuclidianView_2_3DZ(view, eval);
                                                                x0 = eval[0];
                                                                y0 = eval[1];
                                                                if (geogebra_src_DrawParametricCurve_isUndefined___3DZ(eval)) {
                                                                return geogebra_src_DrawParametricCurve_plotProblemInterval__Lgeogebra_src_ParametricCurve_2DDIDLgeogebra_src_EuclidianView_2Lgeogebra_src_GeneralPathClipped_2ZLgeogebra_src_DrawParametricCurve$Gap_2Lgeogebra_src_GPoint_2Lgeogebra_src_GPoint_2(curve, t1, t2, intervalDepth, max_param_step, view, gp, calcLabelPos, moveToAllowed, null);
                                                                }
                                                            geogebra_src_ParametricCurve_$evaluateCurve__Lgeogebra_src_ParametricCurve_2D_3DV(curve, t2, eval);
                                                            geogebra_src_DrawParametricCurve_countEvaluations = com_google_gwt_lang_LongLib_add__Lcom_google_gwt_lang_LongLibBase$LongEmul_2Lcom_google_gwt_lang_LongLibBase$LongEmul_2Lcom_google_gwt_lang_LongLibBase$LongEmul_2(geogebra_src_DrawParametricCurve_countEvaluations, P1_longLit);
                                                            onScreen = geogebra_src_EuclidianView_$toScreenCoords__Lgeogebra_src_EuclidianView_2_3DZ(view, eval);
                                                            x = eval[0];
                                                            y = eval[1];
                                                            if (geogebra_src_DrawParametricCurve_isUndefined___3DZ(eval)) {
                                                                return geogebra_src_DrawParametricCurve_plotProblemInterval__Lgeogebra_src_ParametricCurve_2DDIDLgeogebra_src_EuclidianView_2Lgeogebra_src_GeneralPathClipped_2ZLgeogebra_src_DrawParametricCurve$Gap_2Lgeogebra_src_GPoint_2Lgeogebra_src_GPoint_2(curve, t1, t2, intervalDepth, max_param_step, view, gp, calcLabelPos, moveToAllowed, null);
                                                                }
                                                            if (moveToAllowed == 1) {
                                                                geogebra_src_DrawParametricCurve_drawTo__Lgeogebra_src_GeneralPathClipped_2DDZV(gp, x0, y0, false);
                                                                }
                                                            else if (moveToAllowed == 0 || moveToAllowed == 6) {
                                                                geogebra_src_DrawParametricCurve_drawTo__Lgeogebra_src_GeneralPathClipped_2DDZV(gp, x0, y0, true);
                                                                }
                                                            else if (moveToAllowed == 2) {
                                                                d = geogebra_src_GeneralPathClipped_$getCurrentPoint__Lgeogebra_src_GeneralPathClipped_2Lgeogebra_src_GPoint_2(gp).geogebra_src_GPoint_y;
                                                                if (!geogebra_src_Kernel_isEqual__DDZ(d, y0)) {
                                                                geogebra_src_DrawParametricCurve_drawTo__Lgeogebra_src_GeneralPathClipped_2DDZV(gp, -10, d, true);
                                                                geogebra_src_DrawParametricCurve_drawTo__Lgeogebra_src_GeneralPathClipped_2DDZV(gp, -10, y0, true);
                                                                }
                                                            geogebra_src_DrawParametricCurve_drawTo__Lgeogebra_src_GeneralPathClipped_2DDZV(gp, x0, y0, true);
                                                            }
                                                            else if (moveToAllowed == 4) {
                                                                d = geogebra_src_GeneralPathClipped_$getCurrentPoint__Lgeogebra_src_GeneralPathClipped_2Lgeogebra_src_GPoint_2(gp).geogebra_src_GPoint_y;
                                                                if (!geogebra_src_Kernel_isEqual__DDZ(d, y0)) {
                                                                geogebra_src_DrawParametricCurve_drawTo__Lgeogebra_src_GeneralPathClipped_2DDZV(gp, geogebra_src_EuclidianView_$getWidth__Lgeogebra_src_EuclidianView_2I(view) + 10, d, true);
                                                                geogebra_src_DrawParametricCurve_drawTo__Lgeogebra_src_GeneralPathClipped_2DDZV(gp, geogebra_src_EuclidianView_$getWidth__Lgeogebra_src_EuclidianView_2I(view) + 10, y0, true);
                                                                }
                                                            geogebra_src_DrawParametricCurve_drawTo__Lgeogebra_src_GeneralPathClipped_2DDZV(gp, x0, y0, true);
                                                            }
                                                            else if (moveToAllowed == 3) {
                                                                d = geogebra_src_GeneralPathClipped_$getCurrentPoint__Lgeogebra_src_GeneralPathClipped_2Lgeogebra_src_GPoint_2(gp).geogebra_src_GPoint_x;
                                                                if (!geogebra_src_Kernel_isEqual__DDZ(d, x0)) {
                                                                geogebra_src_DrawParametricCurve_drawTo__Lgeogebra_src_GeneralPathClipped_2DDZV(gp, d, -10, true);
                                                                geogebra_src_DrawParametricCurve_drawTo__Lgeogebra_src_GeneralPathClipped_2DDZV(gp, x0, -10, true);
                                                                }
                                                            geogebra_src_DrawParametricCurve_drawTo__Lgeogebra_src_GeneralPathClipped_2DDZV(gp, x0, y0, true);
                                                            }
                                                            else if (moveToAllowed == 5) {
                                                                d = geogebra_src_GeneralPathClipped_$getCurrentPoint__Lgeogebra_src_GeneralPathClipped_2Lgeogebra_src_GPoint_2(gp).geogebra_src_GPoint_x;
                                                                if (!geogebra_src_Kernel_isEqual__DDZ(d, x0)) {
                                                                geogebra_src_DrawParametricCurve_drawTo__Lgeogebra_src_GeneralPathClipped_2DDZV(gp, geogebra_src_GeneralPathClipped_$getCurrentPoint__Lgeogebra_src_GeneralPathClipped_2Lgeogebra_src_GPoint_2(gp).geogebra_src_GPoint_x, geogebra_src_EuclidianView_$getHeight__Lgeogebra_src_EuclidianView_2I(view) + 10, true);
                                                                geogebra_src_DrawParametricCurve_drawTo__Lgeogebra_src_GeneralPathClipped_2DDZV(gp, x0, geogebra_src_EuclidianView_$getHeight__Lgeogebra_src_EuclidianView_2I(view) + 10, true);
                                                                }
                                                            geogebra_src_DrawParametricCurve_drawTo__Lgeogebra_src_GeneralPathClipped_2DDZV(gp, x0, y0, true);
                                                            }
                                                            dyadicStack = com_google_gwt_lang_Array_initDim__Ljava_lang_Class_2Lcom_google_gwt_core_client_JavaScriptObject_2IIILcom_google_gwt_lang_Array_2(com_google_gwt_lang_ClassLiteralHolder__13I_1classLit, CM$, -1, 17, 1);
                                                            depthStack = com_google_gwt_lang_Array_initDim__Ljava_lang_Class_2Lcom_google_gwt_core_client_JavaScriptObject_2IIILcom_google_gwt_lang_Array_2(com_google_gwt_lang_ClassLiteralHolder__13I_1classLit, CM$, -1, 17, 1);
                                                            xStack = com_google_gwt_lang_Array_initDim__Ljava_lang_Class_2Lcom_google_gwt_core_client_JavaScriptObject_2IIILcom_google_gwt_lang_Array_2(com_google_gwt_lang_ClassLiteralHolder__13D_1classLit, CM$, -1, 17, 1);
                                                            yStack = com_google_gwt_lang_Array_initDim__Ljava_lang_Class_2Lcom_google_gwt_core_client_JavaScriptObject_2IIILcom_google_gwt_lang_Array_2(com_google_gwt_lang_ClassLiteralHolder__13D_1classLit, CM$, -1, 17, 1);
                                                            onScreenStack = com_google_gwt_lang_Array_initDim__Ljava_lang_Class_2Lcom_google_gwt_core_client_JavaScriptObject_2IIILcom_google_gwt_lang_Array_2(com_google_gwt_lang_ClassLiteralHolder__13Z_1classLit, CM$, -1, 17, 2);
                                                            divisors = com_google_gwt_lang_Array_initDim__Ljava_lang_Class_2Lcom_google_gwt_core_client_JavaScriptObject_2IIILcom_google_gwt_lang_Array_2(com_google_gwt_lang_ClassLiteralHolder__13D_1classLit, CM$, -1, 17, 1);
                                                            divisors[0] = t2 - t1;
                                                            for (i = 1; i < 17; ++i)
                                                                divisors[i] = divisors[i - 1] / 2;
                                                                i = 1;
                                                                dyadicStack[0] = 1;
                                                                depthStack[0] = 0;
                                                                onScreenStack[0] = onScreen;
                                                                xStack[0] = x;
                                                                yStack[0] = y;
                                                                ydiff = y - y0;
                                                                xdiff = x - x0;
                                                                countDiffZeros = 0;
                                                                geogebra_src_ParametricCurve_$evaluateCurve__Lgeogebra_src_ParametricCurve_2D_3DV(curve, t1 + divisors[16], eval);
                                                                geogebra_src_EuclidianView_$toScreenCoords__Lgeogebra_src_EuclidianView_2_3DZ(view, eval);
                                                                geogebra_src_DrawParametricCurve_countEvaluations = com_google_gwt_lang_LongLib_add__Lcom_google_gwt_lang_LongLibBase$LongEmul_2Lcom_google_gwt_lang_LongLibBase$LongEmul_2Lcom_google_gwt_lang_LongLibBase$LongEmul_2(geogebra_src_DrawParametricCurve_countEvaluations, P1_longLit);
                                                                prevXdiff = eval[0] - x0;
                                                                prevYdiff = eval[1] - y0;
                                                                top = 1;
                                                                depth = 0;
                                                                t = t1;
                                                                left = t1;
                                                                do {
                                                                    segOffScreen = geogebra_src_DrawParametricCurve_isSegmentOffScreen__Lgeogebra_src_EuclidianView_2DDDDZ(view, x0, y0, x, y);
                                                                    distanceOK = segOffScreen || (xdiff <= 0?0 - xdiff:xdiff) <= 10 && (ydiff <= 0?0 - ydiff:ydiff) <= 10;
                                                                    angleOK = geogebra_src_DrawParametricCurve_isAngleOK__DDDDDZ(prevXdiff, prevYdiff, xdiff, ydiff, segOffScreen?geogebra_src_DrawParametricCurve_MAX_1BEND_1OFF_1SCREEN:geogebra_src_DrawParametricCurve_MAX_1BEND);
                                                                    while (depth < 16 && (!distanceOK || !angleOK || divisors[depth] > max_param_step) && countDiffZeros < 1000) {
                                                                    dyadicStack[top] = i;
                                                                    depthStack[top] = depth;
                                                                    onScreenStack[top] = onScreen;
                                                                    xStack[top] = x;
                                                                    yStack[top] = y;
                                                                    i = 2 * i - 1;
                                                                    ++top;
                                                                    ++depth;
                                                                    t = t1 + i * divisors[depth];
                                                                    geogebra_src_ParametricCurve_$evaluateCurve__Lgeogebra_src_ParametricCurve_2D_3DV(curve, t, eval);
                                                                    onScreen = geogebra_src_EuclidianView_$toScreenCoords__Lgeogebra_src_EuclidianView_2_3DZ(view, eval);
                                                                    geogebra_src_DrawParametricCurve_countEvaluations = com_google_gwt_lang_LongLib_add__Lcom_google_gwt_lang_LongLibBase$LongEmul_2Lcom_google_gwt_lang_LongLibBase$LongEmul_2Lcom_google_gwt_lang_LongLibBase$LongEmul_2(geogebra_src_DrawParametricCurve_countEvaluations, P1_longLit);
                                                                    if (geogebra_src_DrawParametricCurve_isUndefined___3DZ(eval)) {
                                                                    singularity = geogebra_src_DrawParametricCurve_isDefinedAround__Lgeogebra_src_ParametricCurve_2DDZ(curve, t, divisors[16]);
                                                                    if (!singularity) {
                                                                    return geogebra_src_DrawParametricCurve_plotProblemInterval__Lgeogebra_src_ParametricCurve_2DDIDLgeogebra_src_EuclidianView_2Lgeogebra_src_GeneralPathClipped_2ZLgeogebra_src_DrawParametricCurve$Gap_2Lgeogebra_src_GPoint_2Lgeogebra_src_GPoint_2(curve, left, t2, intervalDepth, max_param_step, view, gp, calcLabelPos, moveToAllowed, labelPoint);
                                                                    }
                                                                }
                                                                x = eval[0];
                                                                y = eval[1];
                                                                xdiff = x - x0;
                                                                ydiff = y - y0;
                                                                -1.0E-8 < xdiff && xdiff < 1.0E-8 && -1.0E-8 < ydiff && ydiff < 1.0E-8?++countDiffZeros:(countDiffZeros = 0);
                                                                    segOffScreen = geogebra_src_DrawParametricCurve_isSegmentOffScreen__Lgeogebra_src_EuclidianView_2DDDDZ(view, x0, y0, x, y);
                                                                    distanceOK = segOffScreen || (xdiff <= 0?0 - xdiff:xdiff) <= 10 && (ydiff <= 0?0 - ydiff:ydiff) <= 10;
                                                                        angleOK = geogebra_src_DrawParametricCurve_isAngleOK__DDDDDZ(prevXdiff, prevYdiff, xdiff, ydiff, segOffScreen?geogebra_src_DrawParametricCurve_MAX_1BEND_1OFF_1SCREEN:geogebra_src_DrawParametricCurve_MAX_1BEND);
                                                                        }
                                                                        lineTo = true;
                                                                        moveToAllowed == 1?segOffScreen?(lineTo = false):(!angleOK || !distanceOK) && (lineTo = geogebra_src_DrawParametricCurve_isContinuous__Lgeogebra_src_ParametricCurve_2DDIZ(curve, left, t)):moveToAllowed == 6 && geogebra_src_DrawParametricCurve_corner__Lgeogebra_src_GeneralPathClipped_2DDLgeogebra_src_EuclidianView_2V(gp, x, y, view);
                                                                        if (lineTo) {
                                                                            if (nextLineToNeedsMoveToFirst) {
                                                                            geogebra_src_DrawParametricCurve_drawTo__Lgeogebra_src_GeneralPathClipped_2DDZV(gp, moveX, moveY, false);
                                                                            nextLineToNeedsMoveToFirst = false;
                                                                            }
                                                                        geogebra_src_DrawParametricCurve_drawTo__Lgeogebra_src_GeneralPathClipped_2DDZV(gp, x, y, true);
                                                                        }
                                                                        else {
                                                                            moveX = x;
                                                                            moveY = y;
                                                                            nextLineToNeedsMoveToFirst = true;
                                                                            }
                                                                        x0 = x;
                                                                        y0 = y;
                                                                        left = t;
                                                                        if (needLabelPos && onScreen) {
                                                                            xLabel = x + 10;
                                                                            xLabel < 20 && (xLabel = 5);
                                                                            xLabel > geogebra_src_EuclidianView_$getWidth__Lgeogebra_src_EuclidianView_2I(view) - 30 && (xLabel = geogebra_src_EuclidianView_$getWidth__Lgeogebra_src_EuclidianView_2I(view) - 15);
                                                                            yLabel = y + 15;
                                                                            yLabel < 40?(yLabel = 15):yLabel > geogebra_src_EuclidianView_$getHeight__Lgeogebra_src_EuclidianView_2I(view) - 30 && (yLabel = geogebra_src_EuclidianView_$getHeight__Lgeogebra_src_EuclidianView_2I(view) - 5);
                                                                            labelPoint = new geogebra_src_GPoint_GPoint__IIV(com_google_gwt_lang_Cast_round_1int__DI(xLabel), com_google_gwt_lang_Cast_round_1int__DI(yLabel));
                                                                            needLabelPos = false;
                                                                            }
                                                                        --top;
                                                                        y = yStack[top];
                                                                        x = xStack[top];
                                                                        onScreen = onScreenStack[top];
                                                                        depth = depthStack[top] + 1;
                                                                        i = dyadicStack[top] * 2;
                                                                        prevXdiff = xdiff;
                                                                        prevYdiff = ydiff;
                                                                        xdiff = x - x0;
                                                                        ydiff = y - y0;
                                                                        t = t1 + i * divisors[depth];
                                                                        }
                                                                        while (top != 0);
                                                                        return labelPoint;
                                                                        }

                                                                        function geogebra_src_DrawParametricCurve_plotProblemInterval__Lgeogebra_src_ParametricCurve_2DDIDLgeogebra_src_EuclidianView_2Lgeogebra_src_GeneralPathClipped_2ZLgeogebra_src_DrawParametricCurve$Gap_2Lgeogebra_src_GPoint_2Lgeogebra_src_GPoint_2(curve, t1, t2, intervalDepth, max_param_step, view, gp, calcLabelPos, moveToAllowed, labelPoint){
                                                                            var calcLabel, eval, intervalsTooLarge, labelPoint1, labelPoint2, splitParam;
                                                                            if (intervalDepth > 8 || t1 == t2) {
                                                                            return labelPoint;
                                                                            }
                                                                        splitParam = (t1 + t2) / 2;
                                                                        intervalsTooLarge = (t1 - splitParam <= 0?0 - (t1 - splitParam):t1 - splitParam) > max_param_step;
                                                                            if (intervalsTooLarge) {
                                                                                calcLabel = calcLabelPos && !labelPoint;
                                                                                labelPoint1 = geogebra_src_DrawParametricCurve_plotInterval__Lgeogebra_src_ParametricCurve_2DDIDLgeogebra_src_EuclidianView_2Lgeogebra_src_GeneralPathClipped_2ZLgeogebra_src_DrawParametricCurve$Gap_2Lgeogebra_src_GPoint_2(curve, t1, splitParam, intervalDepth + 1, max_param_step, view, gp, calcLabel, moveToAllowed);
                                                                                calcLabel = calcLabel && !labelPoint1;
                                                                                labelPoint2 = geogebra_src_DrawParametricCurve_plotInterval__Lgeogebra_src_ParametricCurve_2DDIDLgeogebra_src_EuclidianView_2Lgeogebra_src_GeneralPathClipped_2ZLgeogebra_src_DrawParametricCurve$Gap_2Lgeogebra_src_GPoint_2(curve, splitParam, t2, intervalDepth + 1, max_param_step, view, gp, calcLabel, moveToAllowed);
                                                                                }
                                                                            else {
                                                                                eval = com_google_gwt_lang_Array_initDim__Ljava_lang_Class_2Lcom_google_gwt_core_client_JavaScriptObject_2IIILcom_google_gwt_lang_Array_2(com_google_gwt_lang_ClassLiteralHolder__13D_1classLit, CM$, -1, 2, 1);
                                                                                geogebra_src_DrawParametricCurve_getDefinedInterval__Lgeogebra_src_ParametricCurve_2DD_3DZ(curve, t1, splitParam, eval);
                                                                                calcLabel = calcLabelPos && !labelPoint;
                                                                                labelPoint1 = geogebra_src_DrawParametricCurve_plotInterval__Lgeogebra_src_ParametricCurve_2DDIDLgeogebra_src_EuclidianView_2Lgeogebra_src_GeneralPathClipped_2ZLgeogebra_src_DrawParametricCurve$Gap_2Lgeogebra_src_GPoint_2(curve, eval[0], eval[1], intervalDepth + 1, max_param_step, view, gp, calcLabel, moveToAllowed);
                                                                                geogebra_src_DrawParametricCurve_getDefinedInterval__Lgeogebra_src_ParametricCurve_2DD_3DZ(curve, splitParam, t2, eval);
                                                                                calcLabel = calcLabel && !labelPoint1;
                                                                                labelPoint2 = geogebra_src_DrawParametricCurve_plotInterval__Lgeogebra_src_ParametricCurve_2DDIDLgeogebra_src_EuclidianView_2Lgeogebra_src_GeneralPathClipped_2ZLgeogebra_src_DrawParametricCurve$Gap_2Lgeogebra_src_GPoint_2(curve, eval[0], eval[1], intervalDepth + 1, max_param_step, view, gp, calcLabel, moveToAllowed);
                                                                                }
                                                                            return labelPoint?labelPoint:labelPoint1?labelPoint1:labelPoint2;
                                                                            }

                                                                            com_google_gwt_lang_SeedUtil_defineSeed__IILcom_google_gwt_core_client_JavaScriptObject_2Lcom_google_gwt_core_client_JavaScriptObject_2(35, 1, {}, geogebra_src_DrawParametricCurve_DrawParametricCurve__V);
                                                                            var geogebra_src_DrawParametricCurve_MAX_1BEND, geogebra_src_DrawParametricCurve_MAX_1BEND_1OFF_1SCREEN, geogebra_src_DrawParametricCurve_countEvaluations = P0_longLit, geogebra_src_DrawParametricCurve_countPoints = 0;
                                                                            function geogebra_src_EuclidianView_$getHeight__Lgeogebra_src_EuclidianView_2I(this$static){
                                                                                    return canvas.height;
                                                                                }

                                                                            function geogebra_src_EuclidianView_$getWidth__Lgeogebra_src_EuclidianView_2I(this$static){
                                                                                return canvas.width;
                                                                                }

                                                                            function geogebra_src_EuclidianView_$toScreenCoords__Lgeogebra_src_EuclidianView_2_3DZ(this$static, eval){
                                                                                    // TOOD: toScreenCoords()
                                                                                    return false;
                                                                                }

                                                                            function geogebra_src_EuclidianView_EuclidianView__IV(){
                                                                                this.geogebra_src_EuclidianView_i = 1;
                                                                                }

                                                                            com_google_gwt_lang_SeedUtil_defineSeed__IILcom_google_gwt_core_client_JavaScriptObject_2Lcom_google_gwt_core_client_JavaScriptObject_2(36, 1, {}, geogebra_src_EuclidianView_EuclidianView__IV);
                                                                            _.geogebra_src_EuclidianView_i = 0;
                                                                            function geogebra_src_GPoint_GPoint__V(){
                                                                                this.geogebra_src_GPoint_x = 0;
                                                                                this.geogebra_src_GPoint_y = 0;
                                                                                }

                                                                            function geogebra_src_GPoint_GPoint__IIV(x, y){
                                                                                this.geogebra_src_GPoint_x = x;
                                                                                this.geogebra_src_GPoint_y = y;
                                                                                }

                                                                            com_google_gwt_lang_SeedUtil_defineSeed__IILcom_google_gwt_core_client_JavaScriptObject_2Lcom_google_gwt_core_client_JavaScriptObject_2(37, 1, {}, geogebra_src_GPoint_GPoint__V, geogebra_src_GPoint_GPoint__IIV);
                                                                            _.geogebra_src_GPoint_x = 0;
                                                                            _.geogebra_src_GPoint_y = 0;
                                                                            function geogebra_src_GeneralPathClipped_$getCurrentPoint__Lgeogebra_src_GeneralPathClipped_2Lgeogebra_src_GPoint_2(gp){
                                                                                    var pt = gp.getCurrentPoint();
                                                                                    return new geogebra_src_GPoint_GPoint__IIV(pt[0], pt[1]);
                                                                                }

function geogebra_src_GeneralPathClipped_$lineTo__Lgeogebra_src_GeneralPathClipped_2DDV(gp, x, y){
  gp.lineTo(x, y);
}

function geogebra_src_GeneralPathClipped_$moveTo__Lgeogebra_src_GeneralPathClipped_2DDV(gp, x, y){
  gp.moveTo(x, y);
}

function geogebra_src_GeneralPathClipped_GeneralPathClipped__IV(){
  this.geogebra_src_GeneralPathClipped_i = 1;
}

com_google_gwt_lang_SeedUtil_defineSeed__IILcom_google_gwt_core_client_JavaScriptObject_2Lcom_google_gwt_core_client_JavaScriptObject_2(38, 1, {}, geogebra_src_GeneralPathClipped_GeneralPathClipped__IV);
_.geogebra_src_GeneralPathClipped_i = 0;
function geogebra_src_Kernel_isEqual__DDZ(x, y){
  if (x == y) {
    return true;
  }
  return x - 1.0E-8 <= y && y <= x + 1.0E-8;
}

function geogebra_src_Kernel_isEqual__DDDZ(x, y, eps){
  if (x == y) {
    return true;
  }
  return x - eps < y && y < x + eps;
}

function geogebra_src_ParametricCurve_$evaluateCurve__Lgeogebra_src_ParametricCurve_2D_3DV(gp, t1, eval){
  gp.evaluateCurve(t1, eval);
}

function geogebra_src_ParametricCurve_$getRealRootFunctionX__Lgeogebra_src_ParametricCurve_2Lgeogebra_src_RealRootFunction_2(){
  $wnd.console.log('public RealRootFunction getRealRootFunctionX()1');
  $wnd.console.log($intern_7);
  $wnd.console.log($intern_7);
  $wnd.console.log($intern_7);
  $wnd.console.log($intern_7);
  $wnd.console.log($intern_7);
  $wnd.console.log($intern_7);
  $wnd.console.log($intern_7);
  $wnd.console.log($intern_7);
  $wnd.console.log($intern_7);
  $wnd.console.log($intern_7);
  $wnd.console.log($intern_7);
  $wnd.console.log($intern_7);
  $wnd.console.log($intern_7);
  $wnd.console.log($intern_7);
  $wnd.console.log($intern_7);
  $wnd.console.log($intern_7);
  $wnd.console.log($intern_7);
  $wnd.console.log($intern_7);
  $wnd.console.log($intern_7);
  $wnd.console.log($intern_7);
  $wnd.console.log($intern_7);
  $wnd.console.log($intern_7);
  $wnd.console.log($intern_7);
  $wnd.console.log($intern_7);
  $wnd.console.log($intern_7);
  $wnd.console.log($intern_7);
  $wnd.console.log($intern_7);
  $wnd.console.log($intern_7);
  $wnd.console.log($intern_7);
  $wnd.console.log($intern_7);
  $wnd.console.log($intern_7);
  $wnd.console.log($intern_7);
  $wnd.console.log($intern_7);
  $wnd.console.log($intern_7);
  $wnd.console.log($intern_7);
  $wnd.console.log($intern_7);
  $wnd.console.log($intern_7);
  $wnd.console.log($intern_7);
  $wnd.console.log($intern_7);
  $wnd.console.log($intern_7);
  $wnd.console.log($intern_7);
  $wnd.console.log($intern_7);
  $wnd.console.log($intern_7);
  $wnd.console.log($intern_7);
  $wnd.console.log($intern_7);
  $wnd.console.log($intern_7);
  $wnd.console.log($intern_7);
  $wnd.console.log($intern_7);
  $wnd.console.log($intern_7);
  $wnd.console.log($intern_7);
  $wnd.console.log($intern_7);
  $wnd.console.log($intern_7);
  $wnd.console.log($intern_7);
  $wnd.console.log($intern_7);
  $wnd.console.log($intern_7);
  $wnd.console.log($intern_7);
  $wnd.console.log($intern_7);
  $wnd.console.log($intern_7);
  $wnd.console.log($intern_7);
  eval('1+2');
  return undefined;
}

function geogebra_src_ParametricCurve_$getRealRootFunctionY__Lgeogebra_src_ParametricCurve_2Lgeogebra_src_RealRootFunction_2(this$static){
  geogebra_src_App_debug__Ljava_lang_String_2V('public RealRootFunction getRealRootFunctionY()1' + this$static.geogebra_src_ParametricCurve_i);
  geogebra_src_App_debug__Ljava_lang_String_2V($intern_8 + this$static.geogebra_src_ParametricCurve_i);
  geogebra_src_App_debug__Ljava_lang_String_2V($intern_8 + this$static.geogebra_src_ParametricCurve_i);
  geogebra_src_App_debug__Ljava_lang_String_2V($intern_8 + this$static.geogebra_src_ParametricCurve_i);
  geogebra_src_App_debug__Ljava_lang_String_2V($intern_8 + this$static.geogebra_src_ParametricCurve_i);
  geogebra_src_App_debug__Ljava_lang_String_2V($intern_8 + this$static.geogebra_src_ParametricCurve_i);
  geogebra_src_App_debug__Ljava_lang_String_2V($intern_8 + this$static.geogebra_src_ParametricCurve_i);
  geogebra_src_App_debug__Ljava_lang_String_2V($intern_8 + this$static.geogebra_src_ParametricCurve_i);
  geogebra_src_App_debug__Ljava_lang_String_2V($intern_8 + this$static.geogebra_src_ParametricCurve_i);
  geogebra_src_App_debug__Ljava_lang_String_2V($intern_8 + this$static.geogebra_src_ParametricCurve_i);
  geogebra_src_App_debug__Ljava_lang_String_2V($intern_8 + this$static.geogebra_src_ParametricCurve_i);
  geogebra_src_App_debug__Ljava_lang_String_2V($intern_8 + this$static.geogebra_src_ParametricCurve_i);
  geogebra_src_App_debug__Ljava_lang_String_2V($intern_8 + this$static.geogebra_src_ParametricCurve_i);
  geogebra_src_App_debug__Ljava_lang_String_2V($intern_8 + this$static.geogebra_src_ParametricCurve_i);
  geogebra_src_App_debug__Ljava_lang_String_2V($intern_8 + this$static.geogebra_src_ParametricCurve_i);
  geogebra_src_App_debug__Ljava_lang_String_2V($intern_8 + this$static.geogebra_src_ParametricCurve_i);
  geogebra_src_App_debug__Ljava_lang_String_2V($intern_8 + this$static.geogebra_src_ParametricCurve_i);
  geogebra_src_App_debug__Ljava_lang_String_2V($intern_8 + this$static.geogebra_src_ParametricCurve_i);
  geogebra_src_App_debug__Ljava_lang_String_2V($intern_8 + this$static.geogebra_src_ParametricCurve_i);
  geogebra_src_App_debug__Ljava_lang_String_2V($intern_8 + this$static.geogebra_src_ParametricCurve_i);
  geogebra_src_App_debug__Ljava_lang_String_2V($intern_8 + this$static.geogebra_src_ParametricCurve_i);
  geogebra_src_App_debug__Ljava_lang_String_2V($intern_8 + this$static.geogebra_src_ParametricCurve_i);
  geogebra_src_App_debug__Ljava_lang_String_2V($intern_8 + this$static.geogebra_src_ParametricCurve_i);
  geogebra_src_App_debug__Ljava_lang_String_2V($intern_8 + this$static.geogebra_src_ParametricCurve_i);
  geogebra_src_App_debug__Ljava_lang_String_2V($intern_8 + this$static.geogebra_src_ParametricCurve_i);
  geogebra_src_App_debug__Ljava_lang_String_2V($intern_8 + this$static.geogebra_src_ParametricCurve_i);
  geogebra_src_App_debug__Ljava_lang_String_2V($intern_8 + this$static.geogebra_src_ParametricCurve_i);
  geogebra_src_App_debug__Ljava_lang_String_2V($intern_8 + this$static.geogebra_src_ParametricCurve_i);
  geogebra_src_App_debug__Ljava_lang_String_2V($intern_8 + this$static.geogebra_src_ParametricCurve_i);
  geogebra_src_App_debug__Ljava_lang_String_2V($intern_8 + this$static.geogebra_src_ParametricCurve_i);
  geogebra_src_App_debug__Ljava_lang_String_2V($intern_8 + this$static.geogebra_src_ParametricCurve_i);
  geogebra_src_App_debug__Ljava_lang_String_2V($intern_8 + this$static.geogebra_src_ParametricCurve_i);
  geogebra_src_App_debug__Ljava_lang_String_2V($intern_8 + this$static.geogebra_src_ParametricCurve_i);
  geogebra_src_App_debug__Ljava_lang_String_2V($intern_8 + this$static.geogebra_src_ParametricCurve_i);
  geogebra_src_App_debug__Ljava_lang_String_2V($intern_8 + this$static.geogebra_src_ParametricCurve_i);
  geogebra_src_App_debug__Ljava_lang_String_2V($intern_8 + this$static.geogebra_src_ParametricCurve_i);
  geogebra_src_App_debug__Ljava_lang_String_2V($intern_8 + this$static.geogebra_src_ParametricCurve_i);
  geogebra_src_App_debug__Ljava_lang_String_2V($intern_8 + this$static.geogebra_src_ParametricCurve_i);
  geogebra_src_App_debug__Ljava_lang_String_2V($intern_8 + this$static.geogebra_src_ParametricCurve_i);
  geogebra_src_App_debug__Ljava_lang_String_2V($intern_8 + this$static.geogebra_src_ParametricCurve_i);
  geogebra_src_App_debug__Ljava_lang_String_2V($intern_8 + this$static.geogebra_src_ParametricCurve_i);
  geogebra_src_App_debug__Ljava_lang_String_2V($intern_8 + this$static.geogebra_src_ParametricCurve_i);
  geogebra_src_App_debug__Ljava_lang_String_2V($intern_8 + this$static.geogebra_src_ParametricCurve_i);
  geogebra_src_App_debug__Ljava_lang_String_2V($intern_8 + this$static.geogebra_src_ParametricCurve_i);
  geogebra_src_App_debug__Ljava_lang_String_2V($intern_8 + this$static.geogebra_src_ParametricCurve_i);
  geogebra_src_App_debug__Ljava_lang_String_2V($intern_8 + this$static.geogebra_src_ParametricCurve_i);
  geogebra_src_App_debug__Ljava_lang_String_2V($intern_8 + this$static.geogebra_src_ParametricCurve_i);
  geogebra_src_App_debug__Ljava_lang_String_2V($intern_8 + this$static.geogebra_src_ParametricCurve_i);
  geogebra_src_App_debug__Ljava_lang_String_2V($intern_8 + this$static.geogebra_src_ParametricCurve_i);
  geogebra_src_App_debug__Ljava_lang_String_2V($intern_8 + this$static.geogebra_src_ParametricCurve_i);
  geogebra_src_App_debug__Ljava_lang_String_2V($intern_8 + this$static.geogebra_src_ParametricCurve_i);
  geogebra_src_App_debug__Ljava_lang_String_2V($intern_8 + this$static.geogebra_src_ParametricCurve_i);
  geogebra_src_App_debug__Ljava_lang_String_2V($intern_8 + this$static.geogebra_src_ParametricCurve_i);
  geogebra_src_App_debug__Ljava_lang_String_2V($intern_8 + this$static.geogebra_src_ParametricCurve_i);
  geogebra_src_App_debug__Ljava_lang_String_2V($intern_8 + this$static.geogebra_src_ParametricCurve_i);
  geogebra_src_App_debug__Ljava_lang_String_2V($intern_8 + this$static.geogebra_src_ParametricCurve_i);
  geogebra_src_App_debug__Ljava_lang_String_2V($intern_8 + this$static.geogebra_src_ParametricCurve_i);
  geogebra_src_App_debug__Ljava_lang_String_2V($intern_8 + this$static.geogebra_src_ParametricCurve_i);
  geogebra_src_App_debug__Ljava_lang_String_2V($intern_8 + this$static.geogebra_src_ParametricCurve_i);
  geogebra_src_App_debug__Ljava_lang_String_2V($intern_8 + this$static.geogebra_src_ParametricCurve_i);
  geogebra_src_App_debug__Ljava_lang_String_2V($intern_8 + this$static.geogebra_src_ParametricCurve_i + 1);
  geogebra_src_App_debug__Ljava_lang_String_2V($intern_8 + this$static.geogebra_src_ParametricCurve_i + 2);
  return null;
}

function geogebra_src_ParametricCurve_ParametricCurve__IV(){
  this.geogebra_src_ParametricCurve_i = 1;
}

com_google_gwt_lang_SeedUtil_defineSeed__IILcom_google_gwt_core_client_JavaScriptObject_2Lcom_google_gwt_core_client_JavaScriptObject_2(41, 1, {}, geogebra_src_ParametricCurve_ParametricCurve__IV);
_.geogebra_src_ParametricCurve_i = 0;
function geogebra_src_RealRootUtil_getDefinedInterval__Lgeogebra_src_RealRootFunction_2DD_3D(a, b){
  var bounds, fa, faNaN, fb, fbNaN, fm, m;
  bounds = com_google_gwt_lang_Array_initDim__Ljava_lang_Class_2Lcom_google_gwt_core_client_JavaScriptObject_2IIILcom_google_gwt_lang_Array_2(com_google_gwt_lang_ClassLiteralHolder__13D_1classLit, CM$, -1, 2, 1);
  fa = null.nullMethod();
  fb = null.nullMethod();
  faNaN = isNaN(fa) || !isFinite(fa);
  fbNaN = isNaN(fb) || !isFinite(fb);
  if (faNaN || fbNaN) {
    if (faNaN && fbNaN) {
      m = (a + b) * 0.5;
      fm = null.nullMethod();
      if (isNaN(fm)) {
        bounds[0] = NaN;
        bounds[1] = NaN;
      }
       else {
        bounds[0] = geogebra_src_RealRootUtil_getDefinitionBorder__Lgeogebra_src_RealRootFunction_2DDD(a, m);
        bounds[1] = geogebra_src_RealRootUtil_getDefinitionBorder__Lgeogebra_src_RealRootFunction_2DDD(m, b);
      }
    }
     else if (faNaN) {
      bounds[0] = geogebra_src_RealRootUtil_getDefinitionBorder__Lgeogebra_src_RealRootFunction_2DDD(a, b);
      bounds[1] = b;
    }
     else {
      bounds[0] = a;
      bounds[1] = geogebra_src_RealRootUtil_getDefinitionBorder__Lgeogebra_src_RealRootFunction_2DDD(a, b);
    }
  }
   else {
    bounds[0] = a;
    bounds[1] = b;
  }
  return bounds;
}

function geogebra_src_RealRootUtil_getDefinitionBorder__Lgeogebra_src_RealRootFunction_2DDD(a, b){
  var fleft, fm, fright, iter, left, leftDef, m, mDef, right, rightDef;
  left = a;
  right = b;
  leftDef = false;
  iter = 0;
  while (iter < 100 && left != right) {
    fleft = null.nullMethod();
    fright = null.nullMethod();
    leftDef = !(isNaN(fleft) || !isFinite(fleft));
    rightDef = !(isNaN(fright) || !isFinite(fright));
    if (leftDef == rightDef) {
      return NaN;
    }
    ++iter;
    m = (left + right) * 0.5;
    fm = null.nullMethod();
    mDef = !(isNaN(fm) || !isFinite(fm));
    mDef == leftDef?(left = m):(right = m);
  }
  if (leftDef) {
    return left;
  }
  return right;
}

function java_lang_Class_Class__V(){
}

function java_lang_Class_createForArray__Ljava_lang_String_2Ljava_lang_String_2ILjava_lang_Class_2Ljava_lang_Class_2(packageName, className, seedId){
  var clazz;
  clazz = new java_lang_Class_Class__V;
  java_lang_Class_isInstantiable__IZ(seedId != 0?-seedId:0) && java_lang_Class_setClassLiteral__ILjava_lang_Class_2V(seedId != 0?-seedId:0, clazz);
  return clazz;
}

function java_lang_Class_createForClass__Ljava_lang_String_2Ljava_lang_String_2ILjava_lang_Class_2Ljava_lang_Class_2(packageName, className, seedId){
  var clazz;
  clazz = new java_lang_Class_Class__V;
  java_lang_Class_isInstantiable__IZ(seedId) && java_lang_Class_setClassLiteral__ILjava_lang_Class_2V(seedId, clazz);
  return clazz;
}

function java_lang_Class_getSeedFunction__Ljava_lang_Class_2Lcom_google_gwt_core_client_JavaScriptObject_2(clazz){
  var func = com_google_gwt_lang_SeedUtil_seedTable[clazz.java_lang_Class_seedId];
  clazz = null;
  return func;
}

function java_lang_Class_isInstantiable__IZ(seedId){
  return typeof seedId == 'number' && seedId > 0;
}

function java_lang_Class_setClassLiteral__ILjava_lang_Class_2V(seedId, clazz){
  var proto;
  clazz.java_lang_Class_seedId = seedId;
  if (seedId == 2) {
    proto = String.prototype;
  }
   else {
    if (seedId > 0) {
      var seed = java_lang_Class_getSeedFunction__Ljava_lang_Class_2Lcom_google_gwt_core_client_JavaScriptObject_2(clazz);
      if (seed) {
        proto = seed.prototype;
      }
       else {
        seed = com_google_gwt_lang_SeedUtil_seedTable[seedId] = function(){
        }
        ;
        seed.java_lang_Object__1_1_1clazz$ = clazz;
        return;
      }
    }
     else {
      return;
    }
  }
  proto.java_lang_Object__1_1_1clazz$ = clazz;
}

com_google_gwt_lang_SeedUtil_defineSeed__IILcom_google_gwt_core_client_JavaScriptObject_2Lcom_google_gwt_core_client_JavaScriptObject_2(43, 1, {}, java_lang_Class_Class__V);
_.java_lang_Class_seedId = 0;
function java_lang_Math_abs__DD(x){
  return x <= 0?0 - x:x;
}

function java_lang_Math_cos__DD(x){
  return Math.cos(x);
}

function java_lang_Math_max__DDD(x, y){
  return x > y?x:y;
}

function java_lang_Math_sin__DD(x){
  return Math.sin(x);
}

function java_lang_String_$equals__Ljava_lang_String_2Ljava_lang_Object_2Z(this$static, other){
  if (other == null) {
    return false;
  }
  return String(this$static) == other;
}

_ = String.prototype;
_.java_lang_Object_castableTypeMap$ = makeCastMap([Q$java_lang_String]);
function java_lang_StringBuilder_StringBuilder__V(){
  new com_google_gwt_core_client_impl_StringBufferImplAppend_StringBufferImplAppend__V;
}

com_google_gwt_lang_SeedUtil_defineSeed__IILcom_google_gwt_core_client_JavaScriptObject_2Lcom_google_gwt_core_client_JavaScriptObject_2(47, 1, {}, java_lang_StringBuilder_StringBuilder__V);
function org_apache_commons_math_complex_Complex_$clinit__V(){
  org_apache_commons_math_complex_Complex_$clinit__V = nullMethod;
  new org_apache_commons_math_complex_Complex_Complex__DDV(0, 1);
  org_apache_commons_math_complex_Complex_NaN = new org_apache_commons_math_complex_Complex_Complex__DDV(NaN, NaN);
  new org_apache_commons_math_complex_Complex_Complex__DDV(Infinity, Infinity);
  org_apache_commons_math_complex_Complex_ONE = new org_apache_commons_math_complex_Complex_Complex__DDV(1, 0);
  org_apache_commons_math_complex_Complex_ZERO = new org_apache_commons_math_complex_Complex_Complex__DDV(0, 0);
}

function org_apache_commons_math_complex_Complex_$divide__Lorg_apache_commons_math_complex_Complex_2Lorg_apache_commons_math_complex_Complex_2Lorg_apache_commons_math_complex_Complex_2(this$static, rhs){
  var c, d, denominator, q;
  if (this$static.org_apache_commons_math_complex_Complex_isNaN || rhs.org_apache_commons_math_complex_Complex_isNaN) {
    return org_apache_commons_math_complex_Complex_NaN;
  }
  c = rhs.org_apache_commons_math_complex_Complex_real;
  d = rhs.org_apache_commons_math_complex_Complex_imaginary;
  if (c == 0 && d == 0) {
    return org_apache_commons_math_complex_Complex_NaN;
  }
  if (rhs.org_apache_commons_math_complex_Complex_isInfinite && !this$static.org_apache_commons_math_complex_Complex_isInfinite) {
    return org_apache_commons_math_complex_Complex_ZERO;
  }
  if ((c <= 0?0 - c:c) < (d <= 0?0 - d:d)) {
    if (d == 0) {
      return new org_apache_commons_math_complex_Complex_Complex__DDV(this$static.org_apache_commons_math_complex_Complex_real / c, this$static.org_apache_commons_math_complex_Complex_imaginary / c);
    }
    q = c / d;
    denominator = c * q + d;
    return new org_apache_commons_math_complex_Complex_Complex__DDV((this$static.org_apache_commons_math_complex_Complex_real * q + this$static.org_apache_commons_math_complex_Complex_imaginary) / denominator, (this$static.org_apache_commons_math_complex_Complex_imaginary * q - this$static.org_apache_commons_math_complex_Complex_real) / denominator);
  }
   else {
    if (c == 0) {
      return new org_apache_commons_math_complex_Complex_Complex__DDV(this$static.org_apache_commons_math_complex_Complex_imaginary / d, -this$static.org_apache_commons_math_complex_Complex_real / c);
    }
    q = d / c;
    denominator = d * q + c;
    return new org_apache_commons_math_complex_Complex_Complex__DDV((this$static.org_apache_commons_math_complex_Complex_imaginary * q + this$static.org_apache_commons_math_complex_Complex_real) / denominator, (this$static.org_apache_commons_math_complex_Complex_imaginary - this$static.org_apache_commons_math_complex_Complex_real * q) / denominator);
  }
}

function org_apache_commons_math_complex_Complex_$sinh__Lorg_apache_commons_math_complex_Complex_2Lorg_apache_commons_math_complex_Complex_2(this$static){
  if (this$static.org_apache_commons_math_complex_Complex_isNaN) {
    return org_apache_commons_math_complex_Complex_NaN;
  }
  return new org_apache_commons_math_complex_Complex_Complex__DDV(org_apache_commons_math_util_MathUtils_sinh__DD(this$static.org_apache_commons_math_complex_Complex_real) * java_lang_Math_cos__DD(this$static.org_apache_commons_math_complex_Complex_imaginary), org_apache_commons_math_util_MathUtils_cosh__DD(this$static.org_apache_commons_math_complex_Complex_real) * java_lang_Math_sin__DD(this$static.org_apache_commons_math_complex_Complex_imaginary));
}

function org_apache_commons_math_complex_Complex_Complex__DDV(real, imaginary){
  org_apache_commons_math_complex_Complex_$clinit__V();
  this.org_apache_commons_math_complex_Complex_real = real;
  this.org_apache_commons_math_complex_Complex_imaginary = imaginary;
  this.org_apache_commons_math_complex_Complex_isNaN = isNaN(real) || isNaN(imaginary);
  this.org_apache_commons_math_complex_Complex_isInfinite = !this.org_apache_commons_math_complex_Complex_isNaN && (!isFinite(real) || !isFinite(imaginary));
}

com_google_gwt_lang_SeedUtil_defineSeed__IILcom_google_gwt_core_client_JavaScriptObject_2Lcom_google_gwt_core_client_JavaScriptObject_2(48, 1, {}, org_apache_commons_math_complex_Complex_Complex__DDV);
_.org_apache_commons_math_complex_Complex_imaginary = 0;
_.org_apache_commons_math_complex_Complex_isInfinite = false;
_.org_apache_commons_math_complex_Complex_isNaN = false;
_.org_apache_commons_math_complex_Complex_real = 0;
var org_apache_commons_math_complex_Complex_NaN, org_apache_commons_math_complex_Complex_ONE, org_apache_commons_math_complex_Complex_ZERO;
function org_apache_commons_math_util_MathUtils_cosh__DD(x){
  return (Math.exp(x) + Math.exp(-x)) / 2;
}

function org_apache_commons_math_util_MathUtils_sinh__DD(x){
  return (Math.exp(x) - Math.exp(-x)) / 2;
}

var $entry = com_google_gwt_core_client_impl_Impl_entry__Lcom_google_gwt_core_client_JavaScriptObject_2Lcom_google_gwt_core_client_JavaScriptObject_2;
function gwtOnLoad(errFn, modName, modBase, softPermutationId){
  $moduleName = modName;
  $moduleBase = modBase;
  if (errFn)
    try {
      $entry(com_google_gwt_lang_EntryMethodHolder_init__V)();
    }
     catch (e) {
      errFn(modName);
    }
   else {
    $entry(com_google_gwt_lang_EntryMethodHolder_init__V)();
  }
}

var com_google_gwt_lang_ClassLiteralHolder_Ljava_1lang_1Object_12_1classLit = java_lang_Class_createForClass__Ljava_lang_String_2Ljava_lang_String_2ILjava_lang_Class_2Ljava_lang_Class_2($intern_9, 'Object', 1), com_google_gwt_lang_ClassLiteralHolder_Lcom_1google_1gwt_1core_1client_1JavaScriptObject_12_1classLit = java_lang_Class_createForClass__Ljava_lang_String_2Ljava_lang_String_2ILjava_lang_Class_2Ljava_lang_Class_2($intern_10, 'JavaScriptObject$', 9), com_google_gwt_lang_ClassLiteralHolder__13I_1classLit = java_lang_Class_createForArray__Ljava_lang_String_2Ljava_lang_String_2ILjava_lang_Class_2Ljava_lang_Class_2($intern_11, '[I', 50), com_google_gwt_lang_ClassLiteralHolder__13Z_1classLit = java_lang_Class_createForArray__Ljava_lang_String_2Ljava_lang_String_2ILjava_lang_Class_2Ljava_lang_Class_2($intern_11, '[Z', 51), com_google_gwt_lang_ClassLiteralHolder_Ljava_1lang_1Throwable_12_1classLit = java_lang_Class_createForClass__Ljava_lang_String_2Ljava_lang_String_2ILjava_lang_Class_2Ljava_lang_Class_2($intern_9, 'Throwable', 8), com_google_gwt_lang_ClassLiteralHolder_Ljava_1lang_1Exception_12_1classLit = java_lang_Class_createForClass__Ljava_lang_String_2Ljava_lang_String_2ILjava_lang_Class_2Ljava_lang_Class_2($intern_9, 'Exception', 7), com_google_gwt_lang_ClassLiteralHolder_Ljava_1lang_1RuntimeException_12_1classLit = java_lang_Class_createForClass__Ljava_lang_String_2Ljava_lang_String_2ILjava_lang_Class_2Ljava_lang_Class_2($intern_9, 'RuntimeException', 6), com_google_gwt_lang_ClassLiteralHolder_Lcom_1google_1gwt_1lang_1LongLibBase$LongEmul_12_1classLit = java_lang_Class_createForClass__Ljava_lang_String_2Ljava_lang_String_2ILjava_lang_Class_2Ljava_lang_Class_2($intern_12, 'LongLibBase$LongEmul', 27), com_google_gwt_lang_ClassLiteralHolder_Lcom_1google_1gwt_1lang_1SeedUtil_12_1classLit = java_lang_Class_createForClass__Ljava_lang_String_2Ljava_lang_String_2ILjava_lang_Class_2Ljava_lang_Class_2($intern_12, 'SeedUtil', 28), com_google_gwt_lang_ClassLiteralHolder_Ljava_1lang_1Class_12_1classLit = java_lang_Class_createForClass__Ljava_lang_String_2Ljava_lang_String_2ILjava_lang_Class_2Ljava_lang_Class_2($intern_9, 'Class', 43), com_google_gwt_lang_ClassLiteralHolder__13D_1classLit = java_lang_Class_createForArray__Ljava_lang_String_2Ljava_lang_String_2ILjava_lang_Class_2Ljava_lang_Class_2($intern_11, '[D', 52), com_google_gwt_lang_ClassLiteralHolder_Ljava_1lang_1String_12_1classLit = java_lang_Class_createForClass__Ljava_lang_String_2Ljava_lang_String_2ILjava_lang_Class_2Ljava_lang_Class_2($intern_9, 'String', 2), com_google_gwt_lang_ClassLiteralHolder_Ljava_1lang_1StringBuilder_12_1classLit = java_lang_Class_createForClass__Ljava_lang_String_2Ljava_lang_String_2ILjava_lang_Class_2Ljava_lang_Class_2($intern_9, 'StringBuilder', 47), com_google_gwt_lang_ClassLiteralHolder_Lcom_1google_1gwt_1core_1client_1JavaScriptException_12_1classLit = java_lang_Class_createForClass__Ljava_lang_String_2Ljava_lang_String_2ILjava_lang_Class_2Ljava_lang_Class_2($intern_10, 'JavaScriptException', 5), com_google_gwt_lang_ClassLiteralHolder__13Ljava_1lang_1String_12_1classLit = java_lang_Class_createForArray__Ljava_lang_String_2Ljava_lang_String_2ILjava_lang_Class_2Ljava_lang_Class_2('[Ljava.lang.', 'String;', 53), com_google_gwt_lang_ClassLiteralHolder_Lgeogebra_1src_1DrawParametricCurve_12_1classLit = java_lang_Class_createForClass__Ljava_lang_String_2Ljava_lang_String_2ILjava_lang_Class_2Ljava_lang_Class_2($intern_13, 'DrawParametricCurve', 35), com_google_gwt_lang_ClassLiteralHolder_Lorg_1apache_1commons_1math_1complex_1Complex_12_1classLit = java_lang_Class_createForClass__Ljava_lang_String_2Ljava_lang_String_2ILjava_lang_Class_2Ljava_lang_Class_2('org.apache.commons.math.complex.', 'Complex', 48), com_google_gwt_lang_ClassLiteralHolder_Lgeogebra_1src_1ParametricCurve_12_1classLit = java_lang_Class_createForClass__Ljava_lang_String_2Ljava_lang_String_2ILjava_lang_Class_2Ljava_lang_Class_2($intern_13, 'ParametricCurve', 41), com_google_gwt_lang_ClassLiteralHolder_Lgeogebra_1src_1EuclidianView_12_1classLit = java_lang_Class_createForClass__Ljava_lang_String_2Ljava_lang_String_2ILjava_lang_Class_2Ljava_lang_Class_2($intern_13, 'EuclidianView', 36), com_google_gwt_lang_ClassLiteralHolder_Lgeogebra_1src_1GeneralPathClipped_12_1classLit = java_lang_Class_createForClass__Ljava_lang_String_2Ljava_lang_String_2ILjava_lang_Class_2Ljava_lang_Class_2($intern_13, 'GeneralPathClipped', 38), com_google_gwt_lang_ClassLiteralHolder_Lgeogebra_1src_1GPoint_12_1classLit = java_lang_Class_createForClass__Ljava_lang_String_2Ljava_lang_String_2ILjava_lang_Class_2Ljava_lang_Class_2($intern_13, 'GPoint', 37), com_google_gwt_lang_ClassLiteralHolder_Lcom_1google_1gwt_1core_1client_1impl_1StringBufferImpl_12_1classLit = java_lang_Class_createForClass__Ljava_lang_String_2Ljava_lang_String_2ILjava_lang_Class_2Ljava_lang_Class_2($intern_14, 'StringBufferImpl', 15), com_google_gwt_lang_ClassLiteralHolder_Lcom_1google_1gwt_1core_1client_1impl_1StringBufferImplAppend_12_1classLit = java_lang_Class_createForClass__Ljava_lang_String_2Ljava_lang_String_2ILjava_lang_Class_2Ljava_lang_Class_2($intern_14, 'StringBufferImplAppend', 16), com_google_gwt_lang_ClassLiteralHolder_Lcom_1google_1gwt_1core_1client_1Scheduler_12_1classLit = java_lang_Class_createForClass__Ljava_lang_String_2Ljava_lang_String_2ILjava_lang_Class_2Ljava_lang_Class_2($intern_10, 'Scheduler', 11), com_google_gwt_lang_ClassLiteralHolder_Lcom_1google_1gwt_1core_1client_1impl_1SchedulerImpl_12_1classLit = java_lang_Class_createForClass__Ljava_lang_String_2Ljava_lang_String_2ILjava_lang_Class_2Ljava_lang_Class_2($intern_14, 'SchedulerImpl', 13);
$stats && $stats({moduleName:'drawparametriccurve',sessionId:$sessionId,subSystem:'startup',evtGroup:'moduleStartup',millis:(new Date()).getTime(),type:'moduleEvalEnd'});
if ($wnd.drawparametriccurve) $wnd.drawparametriccurve.onScriptLoad();

