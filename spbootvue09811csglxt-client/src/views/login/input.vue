<template>
    <div class="md-input-wrapper" :class="{'md-input-focus':isFocus}" @click="isFocus=true">
        <label for="login_username" v-text="title"></label>
        <input class="md-input" :type="type" autocomplete="on" @blur="blur" @input="$emit('input' , $event.target.value)" :value="value" id="login_username" />
        <span class="md-input-bar"></span>
    </div>
</template>
<style type="text/scss" lang="scss">
    input.md-input:-internal-autofill-selected {
        background-color: transparent !important;
        background-image: none !important;
    }
</style>
<script>
    export default {
        name: "md-input",
        data() {
            return {
                isFocus: false,
            };
        },
        props: {
            value: String,
            title: String,
            type: {
                type: String,
                default: "text",
            },
        },
        watch: {
            value(val) {
                this.isFocus = this.value != "";
            },
        },
        computed: {},
        methods: {
            blur() {
                if (this.value == "") {
                    this.isFocus = false;
                }
            },
        },
        created() {
            this.isFocus = this.value != "";
        },
        mounted() {},
        destroyed() {},
    };
</script>
