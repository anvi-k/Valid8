
function setLastUpdated() {
    const ts = 'Last updated: ' + new Date().toLocaleString('en-US', {
        month: 'short', day: 'numeric', year: 'numeric',
        hour: '2-digit', minute: '2-digit', second: '2-digit'
    });
    document.querySelectorAll('#lastUpdated').forEach(el => el.textContent = ts);
}


function showError(msg) {
    const banner = document.getElementById('errorBanner');
    if (!banner) return;
    if (msg) {
        banner.classList.remove('hidden');
        const inner = banner.querySelector('div');
        if (inner) inner.textContent = '⚠ ' + msg;
    } else {
        banner.classList.add('hidden');
    }
}


async function reloadData() {
    try {
        const res = await fetch('/api/reload', { method: 'POST' });
        const data = await res.json();
        if (!data.success) {
            showError('Reload failed: ' + (data.error || 'unknown'));
        } else {
            showError(null);
        }
    } catch (e) {
        showError('Reload request failed: ' + e.message);
    }
    if (typeof refreshPage === 'function') refreshPage();
}
