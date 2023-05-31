package seadustry.content

import mindustry.content.Items
import mindustry.type.Category
import mindustry.type.ItemStack
import mindustry.world.Block
import seadustry.world.CreateLand

class SeaBlocks {
    companion object {
        lateinit var createLand: Block

        fun load() {
            createLand = CreateLand("createLand").apply {
                requirements(Category.effect, ItemStack.with(Items.sand, 24))
                alwaysUnlocked = true
            }
        }
    }
}
