// will work only on browser

(async function () {
    let allSubmissions = [];
    let offset = 0;
    const limit = 20;

    // Sleep function for the delay
    const sleep = (ms) => new Promise(resolve => setTimeout(resolve, ms));

    // Loop from offset 1 to 100
    while (offset <= 720) {
        const url = `https://leetcode.com/api/submissions/?offset=${offset}&limit=${limit}`;
        console.log(`Fetching: ${url}`);

        // Fetch the data from the API
        try {
            const response = await fetch(url);
            const data = await response.json();

            if (data && data.submissions_dump && data.submissions_dump.length > 0) {
                // Filter for accepted submissions
                const acceptedSubmissions = data.submissions_dump.filter(submission => submission.status_display === "Accepted");

                // Extract the required fields
                acceptedSubmissions.forEach(submission => {
                    allSubmissions.push({
                        question_id: submission.question_id,
                        code: submission.code,
                        title_slug: submission.title_slug,
                        problem_url: `https://leetcode.com/problems/${submission.title_slug}/`
                    });
                });
            }
        } catch (error) {
            console.error(`Error fetching data at offset ${offset}: `, error);
        }

        // Increment offset
        offset+=20;

        // Add a 5-milisecond delay
        await sleep(500);
    }

    // Convert result to JSON
    const jsonResult = JSON.stringify(allSubmissions, null, 2);

    // Create a downloadable JSON file
    const blob = new Blob([jsonResult], { type: "application/json" });
    const link = document.createElement('a');
    link.href = URL.createObjectURL(blob);
    link.download = "all_leetcode_submissions.json";
    document.body.appendChild(link);
    link.click();
    document.body.removeChild(link);

    // Also log the result in console if you prefer copying
    console.log(allSubmissions);
})();