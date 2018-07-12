package bj.rawsteel

import bj.rawsteel.seeder.TemplateSeeder
import bj.rawsteel.seeder.UserSeeder
import org.junit.Test
import javax.annotation.Resource

/**
 * Created by BaiJiFeiLong@gmail.com at 2018/7/12 上午10:48
 */
class AppSeeder : AppTest() {

    @Resource
    private lateinit var templateSeeder: TemplateSeeder

    @Resource
    private lateinit var userSeeder: UserSeeder

    @Test
    fun run() {
        templateSeeder.clearAndSeed()
        userSeeder.clearAndSeed()
    }
}