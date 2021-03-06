val originalInput = "4347\t3350\t196\t162\t233\t4932\t4419\t3485\t4509\t4287\t4433\t4033\t207\t3682\t2193\t4223\n" +
        "648\t94\t778\t957\t1634\t2885\t1964\t2929\t2754\t89\t972\t112\t80\t2819\t543\t2820\n" +
        "400\t133\t1010\t918\t1154\t1008\t126\t150\t1118\t117\t148\t463\t141\t940\t1101\t89\n" +
        "596\t527\t224\t382\t511\t565\t284\t121\t643\t139\t625\t335\t657\t134\t125\t152\n" +
        "2069\t1183\t233\t213\t2192\t193\t2222\t2130\t2073\t2262\t1969\t2159\t2149\t410\t181\t1924\n" +
        "1610\t128\t1021\t511\t740\t1384\t459\t224\t183\t266\t152\t1845\t1423\t230\t1500\t1381\n" +
        "5454\t3936\t250\t5125\t244\t720\t5059\t202\t4877\t5186\t313\t6125\t172\t727\t1982\t748\n" +
        "3390\t3440\t220\t228\t195\t4525\t1759\t1865\t1483\t5174\t4897\t4511\t5663\t4976\t3850\t199\n" +
        "130\t1733\t238\t1123\t231\t1347\t241\t291\t1389\t1392\t269\t1687\t1359\t1694\t1629\t1750\n" +
        "1590\t1394\t101\t434\t1196\t623\t1033\t78\t890\t1413\t74\t1274\t1512\t1043\t1103\t84\n" +
        "203\t236\t3001\t1664\t195\t4616\t2466\t4875\t986\t1681\t152\t3788\t541\t4447\t4063\t5366\n" +
        "216\t4134\t255\t235\t1894\t5454\t1529\t4735\t4962\t220\t2011\t2475\t185\t5060\t4676\t4089\n" +
        "224\t253\t19\t546\t1134\t3666\t3532\t207\t210\t3947\t2290\t3573\t3808\t1494\t4308\t4372\n" +
        "134\t130\t2236\t118\t142\t2350\t3007\t2495\t2813\t2833\t2576\t2704\t169\t2666\t2267\t850\n" +
        "401\t151\t309\t961\t124\t1027\t1084\t389\t1150\t166\t1057\t137\t932\t669\t590\t188\n" +
        "784\t232\t363\t316\t336\t666\t711\t430\t192\t867\t628\t57\t222\t575\t622\t234"

fun main(args: Array<String>) {
    val logic = Logic()
    val input = logic.transformInput(originalInput)

    println(logic.version1(input))
    println(logic.version2(input))
}


class Logic {
    fun transformInput(input: String): List<List<Int>> {
        return input.lines().map{ it.split("\t").map {it.toInt()}}
    }

    fun version1(input: List<List<Int>>): Int {
        return input.sumBy { it.max()!!.minus(it.min()!!) }
    }

    fun version2(input: List<List<Int>>): Int {
        return input.sumBy { row ->
                    row.sumBy { row
                            .filter { element -> element != it && element % it == 0}
                            .sumBy { element -> element / it }}}

    }
}

