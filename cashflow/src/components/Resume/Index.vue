<template>
    <div class="main">
        <p>{{ labelVisual }}</p>
        <h1>{{ amountCurrency }}</h1>
        <div class="graphic">
            <slot name="graphic"></slot>
        </div>
        <div class="action">
            <slot name="action"></slot>
        </div>
    </div>
</template>
<script>
const formatx = Intl.NumberFormat("es-PE", { style: 'currency', currency: 'PEN' });

export default {
    props: {
        label: {
            type: String,
            default: null
        },
        totalLabel: {
            type: String,
        },
        totalAmount: {
            type: Number, 
            default: null
        },
        amount: {
            type: Number,
            default: null
        }
    },
    computed: {
        amountVisual() {
            return (this.amount == null) ? this.totalAmount : this.amount 
        },
        labelVisual() {
            return (this.label == null) ? this.totalLabel : this.label
        },
        amountCurrency() {
            return formatx.format(this.amountVisual)
        },
    }
}
</script>

<style scoped>
    .main {
        display: flex;
        justify-content: center;
        justify-items: center;
        flex-direction: column;
        align-items: center;
        width: 100%;
    }
    h1, p {
        margin: 0;
        text-align: center;
    }
    
    h1{ 
        margin-top: 14px;
        color: green;
    }
    .graphic {
        display: flex;
        justify-content: center;
        align-items: center;
        width: 100%;
        padding: 48px 24px;
        box-sizing: border-box;
    }
</style>