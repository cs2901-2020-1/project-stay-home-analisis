<template>
    <div>
        WELCOME: {{currentUser.username}}
    </div>
</template>

<script>
import { mapState } from 'vuex';
export default {
    name: 'StayHome',
    computed: {
        ...mapState(['currentUser'])
    },
    mounted(){
    this.$store.dispatch("loadAll")
    },
}
</script>

<style lang="scss" scoped>

</style>