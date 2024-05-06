package ru.itis.kpfu.core.common.resources

import dagger.Binds
import dagger.Module

@Module
internal abstract class ResourcesModule {

    @Binds
    abstract fun provideResources(resourcesImpl: ResourcesImpl): Resources
}
