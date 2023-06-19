package skyblock.content

import mindustry.content.Blocks
import mindustry.world.meta.BuildVisibility

class EnableShardCore {
	companion object {
        fun load() {
            Blocks.coreShard.buildVisibility = BuildVisibility.shown
        }
	
	}
}
